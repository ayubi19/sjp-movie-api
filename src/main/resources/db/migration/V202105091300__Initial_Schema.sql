CREATE TABLE IF NOT EXISTS "movie" (
  "id" BIGSERIAL PRIMARY KEY,
  "title" varchar(100) NOT NULL,
  "year" int4 NOT NULL,
  "duration" float4,
  "language" varchar(50),
  "release_date" date NOT NULL,
  "url_image_poster" varchar(255),
  "url_trial_movie" varchar(255),
  "url_full_movie" varchar(255),
  "country" varchar(5),
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS "actor" (
  "id" BIGSERIAL PRIMARY KEY,
  "first_name" varchar(30),
  "last_name" varchar(30),
  "full_name" varchar(60),
  "gender" char,
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS "movie_cast" (
  "id" BIGSERIAL PRIMARY KEY,
  "actor_id" bigint NOT NULL,
  "movie_id" bigint NOT NULL,
  "role" varchar(30),
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS "director" (
  "id" BIGSERIAL PRIMARY KEY,
  "first_name" varchar(30),
  "last_name" varchar(30),
  "full_name" varchar(60),
  "gender" char,
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS "movie_direction" (
  "id" BIGSERIAL PRIMARY KEY,
  "director_id" bigint NOT NULL,
  "movie_id" bigint NOT NULL,
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS "movie_genres" (
  "id" BIGSERIAL PRIMARY KEY,
  "movie_id" bigint NOT NULL,
  "genres_id" bigint NOT NULL,
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS "genres" (
  "id" BIGSERIAL PRIMARY KEY,
  "genre" varchar(30),
  "description" text,
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS "movie_rating" (
  "id" BIGSERIAL PRIMARY KEY,
  "movie_id" bigint NOT NULL,
  "reviewer_id" bigint NOT NULL,
  "score" float4 NOT NULL,
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS "reviewer" (
  "id" BIGSERIAL PRIMARY KEY,
  "name" varchar(30),
  "age" int4 NOT NULL,
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

CREATE TABLE IF NOT EXISTS "user_app" (
  "id" BIGSERIAL PRIMARY KEY,
  "full_name" varchar(150) NOT NULL,
  "email" varchar(150) NOT NULL,
  "password" varchar(200) NOT NULL,
  "role" varchar(20) NOT NULL,
  "created_by" bigint NOT NULL,
  "created_on" timestamp NOT NULL DEFAULT (now()),
  "modified_by" bigint,
  "modified_on" timestamp,
  "is_deleted" boolean DEFAULT false
);

ALTER TABLE "movie_cast" ADD FOREIGN KEY ("actor_id") REFERENCES "actor" ("id");

ALTER TABLE "movie_cast" ADD FOREIGN KEY ("movie_id") REFERENCES "movie" ("id");

ALTER TABLE "movie_direction" ADD FOREIGN KEY ("director_id") REFERENCES "director" ("id");

ALTER TABLE "movie_direction" ADD FOREIGN KEY ("movie_id") REFERENCES "movie" ("id");

ALTER TABLE "movie_genres" ADD FOREIGN KEY ("movie_id") REFERENCES "movie" ("id");

ALTER TABLE "movie_genres" ADD FOREIGN KEY ("genres_id") REFERENCES "genres" ("id");

ALTER TABLE "movie_rating" ADD FOREIGN KEY ("movie_id") REFERENCES "movie" ("id");

ALTER TABLE "movie_rating" ADD FOREIGN KEY ("reviewer_id") REFERENCES "reviewer" ("id");

CREATE INDEX "movie_index_id" ON "movie" ("id");

CREATE UNIQUE INDEX ON "movie" ("title");

CREATE INDEX "actor_index_id" ON "actor" ("id");

CREATE INDEX "movie_cast_index_id" ON "movie_cast" ("id");

CREATE INDEX "director_index_id" ON "director" ("id");

CREATE INDEX "movie_direction_index_id" ON "movie_direction" ("id");

CREATE INDEX "movie_genres_index_id" ON "movie_genres" ("id");

CREATE INDEX "genres_index_id" ON "genres" ("id");

CREATE INDEX "rating_index_id" ON "movie_rating" ("id");

CREATE INDEX "reviewer_index_id" ON "reviewer" ("id");

CREATE INDEX "user_app_index_id" ON "user_app" ("id");