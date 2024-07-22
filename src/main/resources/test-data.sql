-- 기존 데이터 삭제
DELETE FROM item;
DELETE FROM brand;
DELETE FROM category;

-- 카테고리 삽입
INSERT INTO category (name) VALUES ('상의');
INSERT INTO category (name) VALUES ('아우터');
INSERT INTO category (name) VALUES ('바지');
INSERT INTO category (name) VALUES ('스니커즈');
INSERT INTO category (name) VALUES ('가방');
INSERT INTO category (name) VALUES ('모자');
INSERT INTO category (name) VALUES ('양말');
INSERT INTO category (name) VALUES ('액세서리');

-- 브랜드 삽입
INSERT INTO brand (name) VALUES ('A');
INSERT INTO brand (name) VALUES ('B');
INSERT INTO brand (name) VALUES ('C');
INSERT INTO brand (name) VALUES ('D');
INSERT INTO brand (name) VALUES ('E');
INSERT INTO brand (name) VALUES ('F');
INSERT INTO brand (name) VALUES ('G');
INSERT INTO brand (name) VALUES ('H');
INSERT INTO brand (name) VALUES ('I');

-- 상품 삽입
INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item A1', c.id, b.id, 11200 FROM category c, brand b WHERE c.name = '상의' AND b.name = 'A';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item A2', c.id, b.id, 5500 FROM category c, brand b WHERE c.name = '아우터' AND b.name = 'A';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item A3', c.id, b.id, 4200 FROM category c, brand b WHERE c.name = '바지' AND b.name = 'A';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item A4', c.id, b.id, 9000 FROM category c, brand b WHERE c.name = '스니커즈' AND b.name = 'A';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item A5', c.id, b.id, 2000 FROM category c, brand b WHERE c.name = '가방' AND b.name = 'A';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item A6', c.id, b.id, 1700 FROM category c, brand b WHERE c.name = '모자' AND b.name = 'A';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item A7', c.id, b.id, 1800 FROM category c, brand b WHERE c.name = '양말' AND b.name = 'A';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item A8', c.id, b.id, 2300 FROM category c, brand b WHERE c.name = '액세서리' AND b.name = 'A';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item B1', c.id, b.id, 10500 FROM category c, brand b WHERE c.name = '상의' AND b.name = 'B';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item B2', c.id, b.id, 5900 FROM category c, brand b WHERE c.name = '아우터' AND b.name = 'B';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item B3', c.id, b.id, 3800 FROM category c, brand b WHERE c.name = '바지' AND b.name = 'B';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item B4', c.id, b.id, 9100 FROM category c, brand b WHERE c.name = '스니커즈' AND b.name = 'B';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item B5', c.id, b.id, 2100 FROM category c, brand b WHERE c.name = '가방' AND b.name = 'B';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item B6', c.id, b.id, 2000 FROM category c, brand b WHERE c.name = '모자' AND b.name = 'B';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item B7', c.id, b.id, 2000 FROM category c, brand b WHERE c.name = '양말' AND b.name = 'B';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item B8', c.id, b.id, 2200 FROM category c, brand b WHERE c.name = '액세서리' AND b.name = 'B';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item C1', c.id, b.id, 10000 FROM category c, brand b WHERE c.name = '상의' AND b.name = 'C';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item C2', c.id, b.id, 6200 FROM category c, brand b WHERE c.name = '아우터' AND b.name = 'C';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item C3', c.id, b.id, 3300 FROM category c, brand b WHERE c.name = '바지' AND b.name = 'C';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item C4', c.id, b.id, 9200 FROM category c, brand b WHERE c.name = '스니커즈' AND b.name = 'C';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item C5', c.id, b.id, 2200 FROM category c, brand b WHERE c.name = '가방' AND b.name = 'C';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item C6', c.id, b.id, 1900 FROM category c, brand b WHERE c.name = '모자' AND b.name = 'C';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item C7', c.id, b.id, 2200 FROM category c, brand b WHERE c.name = '양말' AND b.name = 'C';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item C8', c.id, b.id, 2100 FROM category c, brand b WHERE c.name = '액세서리' AND b.name = 'C';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item D1', c.id, b.id, 10100 FROM category c, brand b WHERE c.name = '상의' AND b.name = 'D';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item D2', c.id, b.id, 5100 FROM category c, brand b WHERE c.name = '아우터' AND b.name = 'D';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item D3', c.id, b.id, 3000 FROM category c, brand b WHERE c.name = '바지' AND b.name = 'D';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item D4', c.id, b.id, 9500 FROM category c, brand b WHERE c.name = '스니커즈' AND b.name = 'D';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item D5', c.id, b.id, 2500 FROM category c, brand b WHERE c.name = '가방' AND b.name = 'D';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item D6', c.id, b.id, 1500 FROM category c, brand b WHERE c.name = '모자' AND b.name = 'D';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item D7', c.id, b.id, 2400 FROM category c, brand b WHERE c.name = '양말' AND b.name = 'D';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item D8', c.id, b.id, 2000 FROM category c, brand b WHERE c.name = '액세서리' AND b.name = 'D';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item E1', c.id, b.id, 10700 FROM category c, brand b WHERE c.name = '상의' AND b.name = 'E';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item E2', c.id, b.id, 5000 FROM category c, brand b WHERE c.name = '아우터' AND b.name = 'E';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item E3', c.id, b.id, 3800 FROM category c, brand b WHERE c.name = '바지' AND b.name = 'E';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item E4', c.id, b.id, 9900 FROM category c, brand b WHERE c.name = '스니커즈' AND b.name = 'E';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item E5', c.id, b.id, 2300 FROM category c, brand b WHERE c.name = '가방' AND b.name = 'E';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item E6', c.id, b.id, 1800 FROM category c, brand b WHERE c.name = '모자' AND b.name = 'E';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item E7', c.id, b.id, 2100 FROM category c, brand b WHERE c.name = '양말' AND b.name = 'E';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item E8', c.id, b.id, 2100 FROM category c, brand b WHERE c.name = '액세서리' AND b.name = 'E';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item F1', c.id, b.id, 11200 FROM category c, brand b WHERE c.name = '상의' AND b.name = 'F';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item F2', c.id, b.id, 7200 FROM category c, brand b WHERE c.name = '아우터' AND b.name = 'F';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item F3', c.id, b.id, 4000 FROM category c, brand b WHERE c.name = '바지' AND b.name = 'F';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item F4', c.id, b.id, 9300 FROM category c, brand b WHERE c.name = '스니커즈' AND b.name = 'F';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item F5', c.id, b.id, 2100 FROM category c, brand b WHERE c.name = '가방' AND b.name = 'F';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item F6', c.id, b.id, 1600 FROM category c, brand b WHERE c.name = '모자' AND b.name = 'F';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item F7', c.id, b.id, 2300 FROM category c, brand b WHERE c.name = '양말' AND b.name = 'F';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item F8', c.id, b.id, 1900 FROM category c, brand b WHERE c.name = '액세서리' AND b.name = 'F';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item G1', c.id, b.id, 10500 FROM category c, brand b WHERE c.name = '상의' AND b.name = 'G';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item G2', c.id, b.id, 5800 FROM category c, brand b WHERE c.name = '아우터' AND b.name = 'G';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item G3', c.id, b.id, 3900 FROM category c, brand b WHERE c.name = '바지' AND b.name = 'G';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item G4', c.id, b.id, 9000 FROM category c, brand b WHERE c.name = '스니커즈' AND b.name = 'G';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item G5', c.id, b.id, 2200 FROM category c, brand b WHERE c.name = '가방' AND b.name = 'G';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item G6', c.id, b.id, 1700 FROM category c, brand b WHERE c.name = '모자' AND b.name = 'G';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item G7', c.id, b.id, 2100 FROM category c, brand b WHERE c.name = '양말' AND b.name = 'G';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item G8', c.id, b.id, 2000 FROM category c, brand b WHERE c.name = '액세서리' AND b.name = 'G';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item H1', c.id, b.id, 10800 FROM category c, brand b WHERE c.name = '상의' AND b.name = 'H';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item H2', c.id, b.id, 6300 FROM category c, brand b WHERE c.name = '아우터' AND b.name = 'H';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item H3', c.id, b.id, 3100 FROM category c, brand b WHERE c.name = '바지' AND b.name = 'H';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item H4', c.id, b.id, 9700 FROM category c, brand b WHERE c.name = '스니커즈' AND b.name = 'H';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item H5', c.id, b.id, 2100 FROM category c, brand b WHERE c.name = '가방' AND b.name = 'H';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item H6', c.id, b.id, 1600 FROM category c, brand b WHERE c.name = '모자' AND b.name = 'H';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item H7', c.id, b.id, 2000 FROM category c, brand b WHERE c.name = '양말' AND b.name = 'H';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item H8', c.id, b.id, 2000 FROM category c, brand b WHERE c.name = '액세서리' AND b.name = 'H';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item I1', c.id, b.id, 11400 FROM category c, brand b WHERE c.name = '상의' AND b.name = 'I';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item I2', c.id, b.id, 6700 FROM category c, brand b WHERE c.name = '아우터' AND b.name = 'I';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item I3', c.id, b.id, 3200 FROM category c, brand b WHERE c.name = '바지' AND b.name = 'I';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item I4', c.id, b.id, 9500 FROM category c, brand b WHERE c.name = '스니커즈' AND b.name = 'I';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item I5', c.id, b.id, 2400 FROM category c, brand b WHERE c.name = '가방' AND b.name = 'I';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item I6', c.id, b.id, 1700 FROM category c, brand b WHERE c.name = '모자' AND b.name = 'I';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item I7', c.id, b.id, 1700 FROM category c, brand b WHERE c.name = '양말' AND b.name = 'I';

INSERT INTO item (item_name, category_id, brand_id, item_price)
SELECT 'Item I8', c.id, b.id, 2400 FROM category c, brand b WHERE c.name = '액세서리' AND b.name = 'I';