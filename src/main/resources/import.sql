INSERT INTO USER (idx, user_id, password, name, email) VALUES (1, 'joonghyun', 'pwd1', '최중현', 'wndgus@gmail.com');
INSERT INTO USER (idx, user_id, password, name, email) VALUES (2, 'dakim', 'pwd2', '김다애', 'ekdo@gmail.com');
INSERT INTO USER (idx, user_id, password, name, email) VALUES (3, 'jangsi', 'pwd3', '장시후', 'tlgn@gmail.com');


INSERT INTO ARTICLE (idx, user_idx, content, category) VALUES(1, 1, '내용1', '01');
INSERT INTO ARTICLE (idx, user_idx, content, category) VALUES(2, 1, '내용2', '01');
INSERT INTO ARTICLE (idx, user_idx, content, category) VALUES(3, 1, '내용3', '01');
INSERT INTO ARTICLE (idx, user_idx, content, category) VALUES(4, 1, '내용4', '01');
INSERT INTO ARTICLE (idx, user_idx, content, category) VALUES(5, 2, '내용5', '01');
INSERT INTO ARTICLE (idx, user_idx, content, category) VALUES(6, 2, '내용6', '01');
INSERT INTO ARTICLE (idx, user_idx, content, category) VALUES(7, 3, '내용7', '02');
INSERT INTO ARTICLE (idx, user_idx, content, category) VALUES(8, 3, '내용88', '02');

INSERT INTO ARTICLE_LIKE_COUNT (article_idx, count) VALUES(1, 2);
INSERT INTO ARTICLE_LIKE_COUNT (article_idx, count) VALUES(2, 2);

INSERT INTO CATEGORY (idx, code) VALUES(1, '01');
INSERT INTO CATEGORY (idx, code) VALUES(2, '02');

INSERT INTO ARTICLE_CATEGORY (article_idx, category_idx) VALUES(1, 1);
INSERT INTO ARTICLE_CATEGORY (article_idx, category_idx) VALUES(1, 2);
INSERT INTO ARTICLE_CATEGORY (article_idx, category_idx) VALUES(2, 1);