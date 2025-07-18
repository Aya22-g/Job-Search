create table if not exists users


INSERT INTO  categories (name, parent_id)
VALUES ('Финансы / Бухгалтерия',1 ),
       ('Маркетинг / Реклама', 2

INSERT INTO cost (type)
VALUES ('Email'),
       ('Телефон');

INSERT INTO users (name, age, email, password, phone_number, avatar, account_type)
VALUES
--Соискатель
('Наргиза Рахимова', 35, 'n.rahimova@designs.kz', 'rootAccess35',
 +998901112233, '/images/avatars/nargiza.jpeg', employer),
-- Работодатель
('Тимур Ахматов', 26, 'timur.ahmatov@gmail.com', 'narG22pass',
 +996705000111, '/images/avatars/timur.jpg', admin);

-- Добавление вакансий
INSERT INTO vacancies (name, description, category_id, salary, exp_from, exp_to, is_active, author_id,
                       created_date, update_time)
VALUES('Финансовый аналитик', 'Анализ финансовых показателей', 4,	120000,	3,	5, true, 7,	2025-07-01	2025-07-15),
      ('SMM-специалист','Продвижение бренда в соцсетях',1, 60000, 1, 3, true, 4, 2025-04-25, 2025-05-15);


INSERT INTO contacts_info (type_id, resume_id, value)
VALUES (1, 1, 'applicant@example.com'),
       (2, 1, '+79161234567');

INSERT INTO education_info (resume_id, institution, program, start_date,
                                end_date, degree)
VALUES (2, 2, 'Ташкентский финансовый институт	Финансовый менеджмент',	2014-09-01,	2018-06-30,	'Бакалавр'),
(1, 1, 'Кыргызский государственный университет', 'Маркетинг', 2016-09-01, 2020-06-30, 'Бакалавр');



INSERT INTO work_experience_info (resume_id, years, company_name, position, responsibilities)
    VALUES (2, 5, 'FinExpert Analytic', 'Финансовый аналитик', 'Финансовое моделирование, анализ отчетности'),
           (1, 3, 'MarketingPro LLC', 'SMM-менеджер', 'Продвижение бренда в Instagram, создание рекламных кампаний');


INSERT INTO responded_applicants (resume_id, vacancy_id, confirmation)
    VALUES(1, 1, false),
       (2, 2, true);

INSERT INTO messages (responded_applicants_id, content, timestamp) VALUES
(1, 'Здравствуйте, я хотел бы уточнить детали по вакансии', NOW()),
(2, 'Ваше резюме нам подходит, приглашаем на собеседование', NOW());