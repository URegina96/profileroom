ProfileRoom - минималистичное приложение, которое демонстрирует работу компонента Room      \

 ❀  Пример минималистичного приложения, которое демонстрирует работу компонента Room:

Минималистичный дизайн:
- Экран профиля пользователя: Простой экран, на котором отображается информация о пользователе, такая как имя, возраст, электронная почта и т. д.
- Экран редактирования профиля: Экран, где пользователь может редактировать свои данные.

Функционал:
1. Отображение профиля пользователя: При запуске приложения отображаются данные о пользователе, сохраненные в базе данных.
2. Редактирование профиля: Пользователь может редактировать свои данные, включая имя, возраст, электронную почту и т. д.
3. Сохранение изменений: После внесения изменений пользователь должен иметь возможность сохранить их в базе данных.

Использование компонента Room:
1. Создание сущности для профиля: Создание класса-сущности для представления профиля пользователя в базе данных.
2. Создание базы данных: Создание класса, расширяющего RoomDatabase, для представления базы данных профиля пользователя.
3. Создание доступа к данным (DAO): Создание интерфейса для доступа к операциям с базой данных, таким как добавление, обновление и получение профиля пользователя.
4. Интеграция с пользовательским интерфейсом: Интеграция Room с функциональностью отображения и редактирования профиля пользователя в пользовательском интерфейсе приложения.

	Такое приложение может быть простым, но демонстрирует основные принципы работы с компонентом Room, включая создание базы данных, сущностей, DAO и их интеграцию с пользовательским интерфейсом  
✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧

❓  Для создания оформления XML для приложения в Android Studio, потребуется создать следующие файлы: 

1. activity_main.xml - разметка для экрана профиля пользователя

2. activity_edit_profile.xml - разметка для экрана редактирования профиля

3. entity/ProfileEntity.java - класс-сущность профиля пользователя

4. database/ProfileDatabase.java - класс RoomDatabase для базы данных профиля пользователя

5. dao/ProfileDao.java - интерфейс для доступа к операциям с базой данных

	Это основные файлы для работы с компонентом Room в приложении. Также понадобится создать ViewModel для взаимодействия между базой данных и пользовательским интерфейсом. Не забудь  подключить Room в проекте через зависимости Gradle.   

❓ Как  подключить Room в проекте через зависимости Gradle  

Для подключения библиотеки Room в проект через зависимости Gradle, необходимо добавить следующие строки кода в файл build.gradle (Module: app) в проект:

```gradle
dependencies {
    implementation "androidx.room:room-runtime:2.5.0"
    annotationProcessor "androidx.room:room-compiler:2.5.0"
}
```
После этого синхронизируй  проект, чтобы Gradle загрузил необходимые библиотеки. Теперь можно использовать Room в проекте для работы с базой данных     

❓ Для сохранения введенных пользователем данных в базе данных при нажатии на кнопку "Save" необходимо выполнить следующие действия:  

1. Создать экземпляр базы данных Room и инициализировать его в активности 

2. Получить значения из EditText для имени, возраста и email после нажатия на кнопку "Save" 

3. Создать объект User с полученными значениями и испольовать метод insertUser из UserDao для сохранения пользователя в базе данных 

4. Добавить необходимые проверки и обработку исключений при сохранении данных  

Код для  обработки исключений в код, чтобы узнать, в чем именно возникает ошибка  
 
```
private fun saveUser(user: User) {
    try {
        GlobalScope.launch(Dispatchers.IO) {
            db.userDao().insertUser(user)
        }
    } catch (e: Exception) {
        Log.e("EditProfile", "Error saving user: ${e.message}")
    }
}

```

В данном примере данные пользователя сохраняются в базу данных Room при нажатии на кнопку "Save"   
Обрати  внимание, что для выполнения операций с базой данных в фоновом потоке используется корутина (`GlobalScope.launch(Dispatchers.IO)`)   Также добавлены  зависимости Room в файл `build.gradle` проекта   

 ❀  Для сохранения введенных пользователем данных в базе данных при нажатии на кнопку "Save" необходимо выполнить следующие действия:
1. Создать экземпляр базы данных Room и инициализировать его в активности 

➤Для сохранения данных в базе данных при нажатии на кнопку "Save" в активности EditProfile необходимо выполнить следующие действия 
1. Инициализировать базу данных Room в активности EditProfile   
2. Добавить соответствующий метод для получения данных из EditText и вызов метода insertUser для сохранения данных в базе данных 
3. Обновить интерфейс UserDao, чтобы предоставить метод для вставки нового пользователя 
Теперь при нажатии на кнопку "Save" данные, введенные пользователем, будут сохраняться в базе данных с помощью Room   

❓ Для чего нужен каждый класс и в каком порядке их создают  

1. MainActivity - класс, отвечающий за основной экран приложения. В нем создается кнопка для перехода на экран EditProfile.

2. EditProfile - класс, отвечающий за экран редактирования профиля пользователя. В нем есть кнопки для возврата на главный экран и сохранения изменений профиля.

3. AppDatabase - абстрактный класс, представляющий базу данных Room. В нем определен метод для получения объекта Dao.

4. User - класс, представляющий сущность пользователя в базе данных. Содержит поля для имени, возраста и email пользователя.

5. UserDao - интерфейс, содержащий метод для вставки нового пользователя в базу данных.

Порядок создания классов должен быть следующим:
1. Создание классов User и UserDao.
2. Создание класса AppDatabase.
3. Использование Room в MainActivity и EditProfile для сохранения и получения данных из базы данных.

Проверь также, что подключены все необходимые зависимости для работы Room в файле build.gradle:

```gradle
implementation 'androidx.room:room-runtime:2.5.0'
kapt 'androidx.room:room-compiler:2.5.0'
``` 
Убедитесь, что в проекте создан класс, который расширяет класс Application и инициализирует базу данных Room. 
✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧

❓ Для создания класса, который расширяет класс Application и инициализирует базу данных Room, необходимо следовать следующим шагам:
1. Создается  новый класс, который будет расширять класс Application:
2. Создается  интерфейс для базы данных Room:
3. Создается  класс сущности для базы данных Room:
4. Создается  интерфейс для доступа к данным (DAO) для базы данных Room:
Теперь есть класс, который расширяет класс Application и инициализирует базу данных Room. В этом классе можно обращаться к базе данных Room и выполнять операции с данными    

❓ Для чего расширять класс Application   
Расширение класса Application позволяет добавить новые функциональности и поведения приложению. Это может понадобиться, например, для управления жизненным циклом приложения, обработки событий, взаимодействия с системой или другими компонентами. Также расширение класса Application может быть полезно для создания собственных методов и свойств, специфичных для вашего приложения.           

