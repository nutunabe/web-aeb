Auth API
1. Регистрация: POST-запрос по адресу: `http://localhost:8080/api/auth/signup`
А также, укажите в теле запроса данные, например:
```
{
    "username": "Admin",
    "email": "admin@trainee.com",
    "password": "123",
    "roles": ["admin"]
}
```
2. Авторизация: POST-запрос по адресу: `http://localhost:8080/api/auth/signin`
А также, укажите в теле запроса данные, например:
```
{
    "username": "Admin",
    "password": "123"
}
```
Авторизация также отправит вам Bearer-токен, требуемый для взаимодействия с дальнейшим API.

Resume API
1.	Чтобы получить все резюме из БД, нужно совершить GET-запрос по адресу:
`http://localhost:8080/controllers/resume/getAll`
2.	Чтобы получить резюме по идентификатору, нужно совершить GET-запрос по адресу:
(Вместо {id}, указываете число)
`http://localhost:8080/controllers/resume/get/{id}`
3.	Чтобы редактировать резюме, то нужно совершить PUT-запрос по адресу:
`http://localhost:8080/controllers/resume/update`
А также, в теле запроса должен быть JSON, например:
(Внимание, идентификатор нужно указать корректный и его нельзя изменить, иначе вы получите исключение.)
```
{
    "id": 1,
    "firstName": "Алексеев",
    "secondName": "Алексей",
    "patronymic": "Алексеевич",
    "birthdate": "2000-01-01",
    "email": "alexei@trainee.aeb.ru",
    "phoneNumber": "+79999999",
    "education": [
        "бакалавр",
        "магистратура"
    ],
    "eduWorks": "Учебные группы",
    "goal": "Успешно завершить практику",
    "expWork": "10 лет",
    "expPractice": "111 лет",
    "softSkills": "Общительность, дружелюбность",
    "hardSkills": "C#, Java",
    "langKnowledge": "Якутский, русский и английский",
    "imgUrl": "nothing",
    "eduGroup": "М-ГРУППА-21",
    "resumeStatus": "STATUS_CHECKED"
}
```
4.	Чтобы удалить резюме, то нужно совершить DELETE-запрос по адресу:
`http://localhost:8080/controllers/resume/delete/{id}`
