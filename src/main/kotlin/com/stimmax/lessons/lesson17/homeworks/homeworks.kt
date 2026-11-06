package com.stimmax.lessons.lesson17.homeworks

// Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var) и методов (аргументы и возвращаемые значения), 
// включая модификаторы доступа (private для приватных)




class ArcadeMachine(
    //  Постоянные характеристики (не меняются, доступны для чтения) ---
    val color: String,
    val model: String,
    val hasJoystick: Boolean,
    val gameList: List<String>, // Список игр обычно загружен изначально и не меняется на ходу

    //  Настройки автомата (доступны для чтения всем, но меняются только внутри/специальными методами) 
    val ticketPrice: Double, // Стоимость сеанса (обычно val, если меняется — делают private var)
    
    //  Контакты и владельцы (публичные данные для связи) 
    var owner: String,
    var supportPhone: String
) {
    // Внутреннее состояние автомата (категорически скрыто от прямого изменения извне) 
    private var isTurnedOn: Boolean = false
    private var isOsLoaded: Boolean = false
    private var isSessionPaid: Boolean = false
    private var cashBalance: Double = 0.0
    private var pinCode: String = "1234" // Пин-код должен быть строго приватным

    // ПУБЛИЧНЫЕ МЕТОДЫ 

    // Включить автомат
    fun turnOn() {
        if (!isTurnedOn) {
            isTurnedOn = true
            loadOs() // Автоматически запускаем загрузку ОС при включении
        }
    }

    // Выключить автомат
    fun turnOff() {
        if (isTurnedOn) {
            shutdownOs() // Перед выключением корректно гасим ОС
            isTurnedOn = false
        }
    }

    // Показать список игр 
    fun showGameList(): List<String> {
        return gameList
    }

    // Оплатить игровой сеанс 
    fun payForSession(amount: Double): Boolean {
        if (!isTurnedOn || !isOsLoaded) return false
        
        if (amount >= ticketPrice) {
            cashBalance += amount
            isSessionPaid = true
            return true
        }
        return false
    }

    // Включить игру 
    fun startGame(gameName: String) {
        if (isTurnedOn && isOsLoaded && isSessionPaid && gameList.contains(gameName)) {
            println("Игра $gameName запущена!")
            isSessionPaid = false // Сеанс использован
        } else {
            println("Запуск невозможен: проверьте оплату или включен ли автомат.")
        }
    }

    // Забрать наличные с помощью пин-кода 
    fun withdrawCash(enteredPin: String): Double {
        if (enteredPin == pinCode) {
            return openSafeAndDispenseCash() // Если пин верный, вызываем приватный метод открытия сейфа
        }
        println("Неверный пин-код!")
        return 0.0
    }

    //  ПРИВАТНЫЕ МЕТОДЫ 

    // Загрузить ОС 
    private fun loadOs() {
        if (isTurnedOn) {
            isOsLoaded = true
        }
    }

    // Завершить работу ОС
    private fun shutdownOs() {
        isOsLoaded = false
    }

    // Открыть сейф и выдать наличные
    private fun openSafeAndDispenseCash(): Double {
        val cashToDispense = cashBalance
        cashBalance = 0.0 // Обнуляем баланс внутри автомата
        return cashToDispense
    }
}

// ПОЧЕМУЧКА
abstract class BaseClass(
//// 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass 
 // Потому что в ChildrenClass объявлено собственное новое поле 
  private val privateVal: String,
//2. объясни, почему это поле недоступно в main()
  // Модификатор protected разрешает доступ к полю только внутри самого класса и его классов-наследников
  protected val protectedVal: String, 
  val publicVal: String
) {

  var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
      "4. Доработай ChildrenClass таким образом, чтобы это получилось"
	  //Чтобы это обойти, в ChildrenClass мы переопределяем (override) метод verifyPublicField, заставляя его всегда возвращать true
      set(value) {
          if (verifyPublicField(value)) {
              field = value
          }
      }
  protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
  //Поле privateField объявлено как private в BaseClass,  поэтому не получится
  private var privateField = "6. добавь сеттер чтобы изменить меня из main()"
  fun getAll(): String {
      return mapOf(
          "privateVal" to privateVal,
          "protectedVal" to protectedVal,
          "publicVal" to publicVal,
          "publicField" to publicField,
          "protectedField" to protectedField,
          "privateField" to privateField,
          "generate" to generate(),
      ).map { "${it.key}: ${it.value}" }
          .joinToString("\n")
  }
  fun printText() {
      privatePrint()
  }
  // 7. объясни, почему эта функция не может быть публичной
  // тип ProtectedClass, который сам объявлен как protected . Функция секеретная, так как внешний код не будет знать, что это за класс.
  protected open fun getProtectedClass() = ProtectedClass()
  protected open fun verifyPublicField(value: String): Boolean {
      return value.length < 3
  }
  // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
  // Потому что функция generate() помечена ключевым словом open в родителе и переопределена (override) в ChildrenClass/ даже если метод generate() вызывается изнутри родительского метода getAll(), версия из ChildrenClass
  open fun generate(): String {
      return "Это генерация из родительского класса"
  }
  private fun privatePrint() {
      println("Печать из класса BaseClass")
  }
  // 9. объясни, почему эта функция не может быть публичной или protected
  // функция возвращает тип PrivateClass, который скрыт модификатором private. Она обязана быть не менее строгой, чем видимость самого класса
  private fun getPrivateClass() = PrivateClass()
  
  protected class ProtectedClass() {}
    
  private class PrivateClass() {}
}
class ChildrenClass(
  val privateVal: String,
  protectedVal: String,
  // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
  //доступен потому, что ChildrenClass наследуется от BaseClass, в котором это поле уже объявлено как публичное поле класса 
  publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {
  // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
  // Класс ChildrenClass расширяет BaseClass Все public и protected методы родителя автоматически становятся частью дочернего класса
  
  // 12. проверь, что выводится на печать при вызове функции printText()
  // и объясни, почему не происходит переопределение метода privatePrint()
  // Функция privatePrint() в родителе является приватной. Наследник её не видит. Метод printText() внутри BaseClass продолжает вызывать свою родную приватную функцию.


    // 5. Публичный сеттер для изменения protectedField из main
    fun setProtectedFieldInChild(value: String) {
        protectedField = value
    }		
    // 4. Переопределяем
    override fun verifyPublicField(value: String): Boolean {
        return true // Теперь пропускает "Антонио Бандерас"
    }
  private fun privatePrint() {
      println("Печать из класса ChildrenClass")
  }
  override fun generate(): String {
      return "Это генерация из дочернего класса"
  }
}


fun main() {
    // Создаем экземпляр доработанного класса
    val child = ChildrenClass(
        privateVal = "Приватное в родителе, но новое в дочернем",
        protectedVal = "Защищенное секретное значение",
        publicVal = "Публичное значение"
    )

    // 3. Изменяем publicField на Антонио Бандераса через override publicField
    child.publicField = "Антонио Бандерас"

    // 5. Изменяем protectedField через созданный сеттер в наследнике
    child.setProtectedFieldInChild("Новое защищенное значение из main")

    // Проверяем результат через getAll()
    println(child.getAll())
    
    println(" Проверка printText() ")
    child.printText() // Выведет текст родительского класса
}