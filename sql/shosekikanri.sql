drop database if exists shosekikanri;
create database shosekikanri;
use shosekikanri;

create table user(
id varchar(4) not null primary key,
name varchar(100) not null,
password varchar(255) not null default "syscom",
created_at datetime not null default current_timestamp,
index(id),
index(password)
);

insert into user(
id,name
)values
("001","保木本朗"),
("003","深井健太"),
("004","魚住直代"),
("006","鈴木留美"),
("007","沖津明花"),
("008","海野建二"),
("101","今井幸紀"),
("102","天谷健司"),
("103","安蒜未花"),
("104","加倉井嘉輩"),
("105","平塚孝之"),
("106","大田啓昭"),
("107","出雲祐次"),
("202","上原渉"),
("203","山本剛"),
("204","木村彰宏"),
("205","山野邉貴也"),
("206","坂口健太郎"),
("207","岩瀬貴史"),
("208","畑山光瑠"),
("209","森愛美"),
("210","田中敦志"),
("211","冨内峻太郎"),
("212","細谷香菜"),
("213","齋藤礼欧"),
("214","杉本慎"),
("301","家子和也"),
("302","瀧祐也"),
("303","斎藤寛之"),
("304","瀬野尾健太"),
("306","栢菅紀之"),
("307","高村敬生"),
("308","石川勇希"),
("401","小鹿真生"),
("402","池田充"),
("403","西山喜喬"),
("404","安福翔"),
("405","東隼"),
("406","森高信")
;

create table book(
book_number int not null auto_increment primary key,
title varchar(100) not null,
title_kana varchar(200) not null,
author varchar(100) not null,
contents varchar(100),
img_path varchar(255),
edit_person varchar(100) not null,
delete_check varchar(1) not null default "×",
edited_date datetime not null default current_timestamp,
index(title),
index(author),
index(contents),
index(img_path)
);

insert into book(
title,title_kana,author,contents,img_path,edit_person
)values
("この人と一緒に働きたい","コノヒトトイッショニハタラキタイ","わからない","朝日新聞社","image/001.jpg","杉本"),
("ビジネス・ゲーム","ビジネス・ゲーム","海外の方","集英社","image/002.jpg","杉本"),
("中国に入っては中国式交渉術に従え！","チュウゴクニハイッテハチュウゴクシキコウショウジュツニシタガエ","qaz","角川書店","image/003.jpg","田中"),
("装丁デザインのアイデア！","ソウテイデザインノアイデア","ert","ニコニコ出版","image/004.jpg","杉本"),
("カタツムリが食べる音","カラツムリガタベルオト","ウィリアム","新聞社","image/005.jpg","杉本"),
("なんでも気になる心配性をなおす本","ナンデモキニナルシンパイショウヲナオスホン","青木","aa出版社","image/006.jpg","杉本"),
("一人一億稼ぐ会社の鉄則","ヒトリイチオクカセグカイシャノテッソク","山本","どくだみ出版社","image/007.jpg","杉本"),
("36HOURS ASIA&OCEANIA","サーティーアワーズエイジアアンドオセアニア","TASCHEN","朝日新聞社","image/008.jpg","杉本"),
("よみがえれフー太郎の森","ヨミガエレフータロウノモリ","新妻","朝日新聞社","image/009.jpg","杉本"),
("ネットでだまされない方法30","ネットデダマサレナイホウホウサンジュウ","日経パソコン","朝日新聞社","image/010.jpg","杉本"),
("誰でも人前で台本なしに10分間話せるようになる本","ダレデモヒトマエデダイホンナシデジュップンカンハナセルヨウニナルホン","別役","朝日新聞社","image/011.jpg","杉本"),
("「トイレが近い」を解決する本","トイレガチカイヲカイケツスルホン","鈴木","朝日新聞社","image/012.jpg","杉本"),
("うまい本","ウマイホン","わからん","朝日新聞社","image/013.jpg","杉本"),
("あんこの本","アンコノホン","姜","朝日新聞社","image/014.jpg","杉本"),
("うづみ火","ウズミビ","銀桂","わからん社","image/015.jpg","杉本")
;

create table reservation_list(
number int not null auto_increment primary key,
borrow_name varchar(255) not null,
book_title varchar(255) not null,
reservation_gain varchar(1),
reserved_date datetime not null default current_timestamp,
lend_date datetime,
return_date datetime,
index(borrow_name),
index(book_title),
index(reservation_gain)
);


create table admin(
id varchar(4) not null primary key,
name varchar(255) not null unique,
password varchar(255) not null default "adminsyscom",
created_at datetime not null default current_timestamp,
index(id),
index(password)
);

insert into admin(
id,name
)values
( "003","深井健太")
;