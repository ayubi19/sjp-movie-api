INSERT INTO public.director
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(1, 'Slamet', 'Rahardjo', 'Slamet Rahardjo', 'M', 0, '2021-05-09 17:06:18.179', NULL, NULL, false);
INSERT INTO public.director
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(2, 'Garin', 'Nugroho', 'Garin Nugroho', 'M', 0, '2021-05-09 17:07:45.017', NULL, NULL, true);
INSERT INTO public.director
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(3, 'Simon', 'McQuoid', 'Simon McQuoid', 'M', 0, '2021-05-09 22:12:24.520', NULL, NULL, false);
INSERT INTO public.director
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(4, 'Anthony', 'Russo', 'Anthony Russo', 'M', 0, '2021-05-10 02:42:16.819', NULL, NULL, false);


INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(1, 'Syahrul', 'ayubi', 'Syahrul ayubi', 'M', 0, '2021-05-09 02:33:25.084', NULL, NULL, false);
INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(2, 'Silvia', 'Ayubi', 'Silvia Ayubi', 'F', 0, '2021-05-09 14:05:53.183', NULL, NULL, true);
INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(3, 'Bambang', 'Waluyo', 'Bambang Waluyo', 'M', 0, '2021-05-09 17:01:49.524', NULL, NULL, false);
INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(4, 'Joe', 'Taslim', 'Joe Taslim', 'M', 0, '2021-05-09 21:36:18.657', NULL, NULL, false);
INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(5, 'Jessica', 'McNamee', 'Jessica McNamee', 'F', 0, '2021-05-09 21:40:04.294', NULL, NULL, false);
INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(6, 'Robert', 'Downey Jr', 'Robert Downey Jr', 'M', 0, '2021-05-10 02:39:59.521', NULL, NULL, false);
INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(7, 'Chris', 'Evans', 'Chris Evans', 'M', 0, '2021-05-10 02:40:16.920', NULL, NULL, false);
INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(8, 'Mark ', 'Ruffalo', 'Mark  Ruffalo', 'M', 0, '2021-05-10 02:41:07.219', NULL, NULL, false);
INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(9, 'Chris', 'Hemsworth', 'Chris Hemsworth', 'M', 0, '2021-05-10 02:41:29.747', NULL, NULL, false);
INSERT INTO public.actor
(id, first_name, last_name, full_name, gender, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(10, 'Scarlett', 'Johansson', 'Scarlett Johansson', 'F', 0, '2021-05-10 02:41:46.477', NULL, NULL, false);


INSERT INTO public.movie
(id, title, "year", duration, "language", release_date, url_image_poster, url_trial_movie, url_full_movie, country, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(1, 'Mortal Kombat', 2021, 1.2799999713897705, 'English', '2021-04-07', 'http://s3.sharemydrive.xyz/wp-content/uploads/2021/04/film-mortal-kombat-2021-lk21.jpg', 'https://www.youtube.com/watch?v=jBa_aHwCbC4', 'https://www.youtube.com/watch?v=d5OfP5ISV9U', 'EN', 0, '2021-05-09 20:13:05.382', NULL, NULL, false);
INSERT INTO public.movie
(id, title, "year", duration, "language", release_date, url_image_poster, url_trial_movie, url_full_movie, country, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(2, 'Stand by Me Doraemon 2', 2020, 1.4500000476837158, 'Japan', '2020-11-20', 'http://s4.sharemydrive.xyz/wp-content/uploads/2021/04/film-stand-by-me-doraemon-2-2020-lk21.jpg', 'https://www.youtube.com/watch?v=uWaJf_nIRNM', 'https://www.youtube.com/watch?v=Xfokv6kGAaE', 'JP', 0, '2021-05-09 20:26:14.401', NULL, NULL, false);
INSERT INTO public.movie
(id, title, "year", duration, "language", release_date, url_image_poster, url_trial_movie, url_full_movie, country, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(3, 'A Writer’s Odyssey', 2021, 2.0999999046325684, 'China', '2021-12-02', 'http://s1.sharemydrive.xyz/wp-content/uploads/2021/04/film-a-writers-odyssey-ci-sha-xiao-shuo-jia-2021-lk21.jpg', 'https://www.youtube.com/watch?v=lsVNI5zvA0w', 'https://www.youtube.com/watch?v=in_00lG7sdw', 'CH', 0, '2021-05-10 02:28:49.412', NULL, NULL, false);
INSERT INTO public.movie
(id, title, "year", duration, "language", release_date, url_image_poster, url_trial_movie, url_full_movie, country, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(4, 'Anunnaki', 2021, 1.159999966621399, 'English US', '2021-12-02', 'http://s7.sharemydrive.xyz/wp-content/uploads/2018/08/film-anunnaki-2017-lk21.jpg', 'https://www.youtube.com/watch?v=O8QclnQuX1c', 'https://www.youtube.com/watch?v=nNyy7Jn-dzA', 'US', 0, '2021-05-10 02:30:33.303', NULL, NULL, false);
INSERT INTO public.movie
(id, title, "year", duration, "language", release_date, url_image_poster, url_trial_movie, url_full_movie, country, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(5, 'Avengers: Endgame', 2019, 3.0999999046325684, 'English US', '2019-04-02', 'http://s1.sharemydrive.xyz/wp-content/uploads/2019/04/film-avengers-endgame-2019-lk21.jpg', 'https://www.youtube.com/watch?v=TcMBFSGVi1c', 'https://www.youtube.com/watch?v=VTm8q2bkjb4', 'US', 0, '2021-05-10 02:34:43.897', NULL, NULL, false);


INSERT INTO public.genres
(id, genre, created_by, created_on, modified_by, modified_on, is_deleted, description)
VALUES(1, 'Action', 0, '2021-05-09 18:24:03.921', NULL, NULL, false, 'Action films are a film genre where action sequences, such as fighting, stunts, car chases or explosions, take precedence over elements like characterization or complex plotting. The action typically involves individual efforts on the part of the hero, in contrast with most war films. The genre is closely linked with the thriller and adventure film genres.');
INSERT INTO public.genres
(id, genre, created_by, created_on, modified_by, modified_on, is_deleted, description)
VALUES(2, 'Adventure', 0, '2021-05-09 18:36:30.326', NULL, NULL, false, 'Adventure movies are a genre of movies. They contain many of the same features of action movies, but are usually set in exotic locations. The main theme is adventure, with the characters often exploring places they have not been before or doing things they have not done before');
INSERT INTO public.genres
(id, genre, created_by, created_on, modified_by, modified_on, is_deleted, description)
VALUES(3, 'Comedy', 0, '2021-05-09 18:36:50.316', NULL, NULL, false, 'Comedy films are funny and entertaining. The films in this genre center around a comedic premise—usually putting someone in a challenging, amusing, or humorous situation they’re not prepared to handle. Good comedy movies are less about making constant jokes, and more about presenting a universally relatable, real-life story with complex characters who learn an important lesson. Mockumentary, dark comedy (or black comedy), romantic comedy, parody/spoof, and slapstick comedy are all examples of comedy subgenres.');
INSERT INTO public.genres
(id, genre, created_by, created_on, modified_by, modified_on, is_deleted, description)
VALUES(4, 'Drama', 0, '2021-05-09 18:38:01.139', NULL, NULL, true, 'The drama genre features stories with high stakes and a lot of conflicts. They’re plot-driven and demand that every character and scene move the story forward. Dramas follow a clearly defined narrative plot structure, portraying real-life scenarios or extreme situations with emotionally-driven characters. Films that fall into drama sub-genres include historical drama, romantic drama, teen drama, medical drama');
INSERT INTO public.genres
(id, genre, created_by, created_on, modified_by, modified_on, is_deleted, description)
VALUES(5, 'Fantasy', 0, '2021-05-09 18:38:42.998', NULL, NULL, false, 'Films in the fantasy genre feature magical and supernatural elements that do not exist in the real world. Although some films juxtapose a real-world setting with fantastical elements, many create entirely imaginary universes with their own laws, logic, and populations of imaginary races and creatures. Like science fiction films, fantasy films are speculative but are not tied to reality or scientific fact. High fantasy, fairy tales, and magical realism are all fantasy subgenres.');


INSERT INTO public.reviewer
(id, "name", created_by, created_on, modified_by, modified_on, is_deleted, age)
VALUES(1, 'Ayubi', 0, '2021-05-09 19:14:26.784', NULL, NULL, false, 29);
INSERT INTO public.reviewer
(id, "name", created_by, created_on, modified_by, modified_on, is_deleted, age)
VALUES(2, 'Silvia', 0, '2021-05-09 19:14:37.660', NULL, NULL, false, 25);


INSERT INTO public.movie_direction
(id, director_id, movie_id, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(1, 3, 1, 0, '2021-05-09 22:13:58.820', NULL, NULL, false);
INSERT INTO public.movie_direction
(id, director_id, movie_id, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(2, 4, 5, 0, '2021-05-10 02:48:42.513', NULL, NULL, false);


INSERT INTO public.movie_cast
(id, actor_id, movie_id, "role", created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(1, 4, 1, 'Sub Zero', 0, '2021-05-09 21:37:43.276', NULL, NULL, false);
INSERT INTO public.movie_cast
(id, actor_id, movie_id, "role", created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(2, 5, 1, 'Sonya', 0, '2021-05-09 21:40:42.912', NULL, NULL, false);
INSERT INTO public.movie_cast
(id, actor_id, movie_id, "role", created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(3, 6, 5, 'Iron Man', 0, '2021-05-10 02:46:09.635', NULL, NULL, false);
INSERT INTO public.movie_cast
(id, actor_id, movie_id, "role", created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(4, 7, 5, 'Captain America', 0, '2021-05-10 02:46:40.463', NULL, NULL, false);


INSERT INTO public.movie_genres
(id, movie_id, genres_id, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(1, 1, 1, 0, '2021-05-09 22:41:56.170', NULL, NULL, false);
INSERT INTO public.movie_genres
(id, movie_id, genres_id, created_by, created_on, modified_by, modified_on, is_deleted)
VALUES(2, 1, 2, 0, '2021-05-09 22:42:53.878', NULL, NULL, true);


INSERT INTO public.movie_rating
(id, movie_id, reviewer_id, created_by, created_on, modified_by, modified_on, is_deleted, score)
VALUES(1, 1, 1, 0, '2021-05-09 23:18:25.938', NULL, NULL, false, 9.0);
INSERT INTO public.movie_rating
(id, movie_id, reviewer_id, created_by, created_on, modified_by, modified_on, is_deleted, score)
VALUES(2, 1, 2, 0, '2021-05-09 23:19:04.933', NULL, NULL, false, 7.9);
