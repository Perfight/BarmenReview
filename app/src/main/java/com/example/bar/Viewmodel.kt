package com.example.bar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BarViewModel : ViewModel() {
    private val _cocktails = MutableStateFlow<List<CocktailPresenter>>(emptyList())
    val cocktails: StateFlow<List<CocktailPresenter>> get() = _cocktails

    init {
        // Инициализация списка коктейлей
        viewModelScope.launch {
            _cocktails.value = listOf(
                CocktailPresenter(
                    id = 1,
                    name = "Маргарита",
                    ingredients = listOf("Текила", "Лайм", "Апельсиновый ликёр"),
                    instructions = """
            1. Наполните шейкер льдом.
            2. Добавьте 50 мл текилы, 25 мл апельсинового ликёра и 15 мл свежего сока лайма.
            3. Хорошо взболтайте в шейкере в течение 10 секунд.
            4. Процедите в бокал, украшенный солью на краях.
            5. Украсьте долькой лайма.
        """.trimIndent(),
                    imageUrl = "https://ru.inshaker.com/uploads/cocktail/promo/39/1629726285-%D0%9C%D0%B0%D1%80%D0%B3%D0%B0%D1%80%D0%B8%D1%82%D0%B0.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 2,
                    name = "Мохито",
                    ingredients = listOf("Ром", "Лайм", "Мята", "Сахар", "Газированная вода"),
                    instructions = """
            1. Разрежьте лайм на четвертинки и положите в высокий бокал.
            2. Добавьте 6-8 листиков свежей мяты и 2 чайные ложки сахара.
            3. Аккуратно разомните лайм и мяту мадлером.
            4. Наполните бокал льдом.
            5. Влейте 50 мл белого рома и долейте газированной водой.
            6. Перемешайте барной ложкой и украсьте веточкой мяты.
        """.trimIndent(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/c/c0/MojitoReydelmojito.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 3,
                    name = "Космополитен",
                    ingredients = listOf("Водка", "Клюквенный сок", "Апельсиновый ликёр"),
                    instructions = """
            1. Наполните шейкер льдом.
            2. Добавьте 40 мл водки, 15 мл апельсинового ликёра, 15 мл сока лайма и 30 мл клюквенного сока.
            3. Хорошо взболтайте в шейкере.
            4. Процедите в охлаждённый коктейльный бокал.
            5. Украсьте долькой апельсина или цедрой.
        """.trimIndent(),
                    imageUrl = "https://s7.stc.all.kpcdn.net/family/wp-content/uploads/2022/08/koktejl-kosmopoliten-960-960x540.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 4,
                    name = "Негрони",
                    ingredients = listOf("Джин", "Красный вермут", "Биттер «Кампари»"),
                    instructions = """
            1. Наполните стакан для смешивания льдом.
            2. Добавьте 30 мл джина, 30 мл красного вермута и 30 мл биттера «Кампари».
            3. Перемешайте барной ложкой.
            4. Процедите в бокал со свежим льдом.
            5. Украсьте апельсиновой цедрой.
        """.trimIndent(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c6/Negroni_served_in_Vancouver_BC.jpg/274px-Negroni_served_in_Vancouver_BC.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 5,
                    name = "Олд Фешен",
                    ingredients = listOf("Бурбон/Виски", "Сахарный сироп", "Биттер «Ангостура»"),
                    instructions = """
            1. В стакан для смешивания добавьте 1 чайную ложку сахарного сиропа и 2-3 капли биттера «Ангостура».
            2. Добавьте 50 мл бурбона или виски.
            3. Перемешайте барной ложкой.
            4. Наполните стакан льдом.
            5. Украсьте вишней или апельсиновой цедрой.
        """.trimIndent(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/15-09-26-RalfR-WLC-0141.jpg/800px-15-09-26-RalfR-WLC-0141.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 6,
                    name = "Палома",
                    ingredients = listOf("Текила", "Грейпфрутовый сок", "Содовая"),
                    instructions = """
            1. Наполните бокал льдом.
            2. Добавьте 50 мл текилы и 100 мл свежего грейпфрутового сока.
            3. Долейте содовой.
            4. Перемешайте барной ложкой.
            5. Украсьте долькой грейпфрута.
        """.trimIndent(),
                    imageUrl = "https://s2.wine.style/images_raw/pages/paloma-56a173f33df78cf7726ac52c1603161078.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 7,
                    name = "Эспрессо Мартини",
                    ingredients = listOf("Водка", "Кофейный ликёр", "Свежий эспрессо"),
                    instructions = """
            1. В шейкер добавьте 50 мл водки, 25 мл кофейного ликёра и 30 мл свежего эспрессо.
            2. Наполните шейкер льдом и хорошо взболтайте.
            3. Процедите в охлаждённый коктейльный бокал.
            4. Украсьте тремя кофейными зёрнами.
        """.trimIndent(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Bistrot_Bruno_Loubet%2C_Clerkenwell%2C_London_%284574785649%29.jpg/800px-Bistrot_Bruno_Loubet%2C_Clerkenwell%2C_London_%284574785649%29.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 8,
                    name = "Дайкири",
                    ingredients = listOf("Белый ром", "Лаймовый сок", "Сахарный сироп"),
                    instructions = """
            1. В шейкер добавьте 50 мл белого рома, 20 мл свежего сока лайма и 15 мл сахарного сиропа.
            2. Наполните шейкер льдом и хорошо взболтайте.
            3. Процедите в охлаждённый коктейльный бокал.
            4. Украсьте долькой лайма.
        """.trimIndent(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Classic_Daiquiri_in_Cocktail_Glass.jpg/1024px-Classic_Daiquiri_in_Cocktail_Glass.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 9,
                    name = "Ирландский кофе",
                    ingredients = listOf("Ирландский виски", "Горячий кофе", "Взбитые сливки"),
                    instructions = """
            1. Налейте 100 мл горячего кофе в бокал.
            2. Добавьте 40 мл ирландского виски и 1 чайную ложку сахара.
            3. Перемешайте до растворения сахара.
            4. Аккуратно положите сверху взбитые сливки.
            5. Подавайте сразу, не перемешивая.
        """.trimIndent(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/9/93/IrishCoffee.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 10,
                    name = "Кайпиринья",
                    ingredients = listOf("Кашаса", "Лайм", "Сахар"),
                    instructions = """
            1. Разрежьте лайм на четвертинки и положите в стакан.
            2. Добавьте 2 чайные ложки сахара.
            3. Разомните лайм и сахар мадлером.
            4. Наполните стакан льдом.
            5. Влейте 50 мл кашасы.
            6. Перемешайте барной ложкой.
        """.trimIndent(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/15-09-26-RalfR-WLC-0048.jpg/800px-15-09-26-RalfR-WLC-0048.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 11,
                    name = "Aperol Spritz",
                    ingredients = listOf("Aperol", "Просекко", "Содовая"),
                    instructions = """
            1. Наполните бокал льдом.
            2. Добавьте 90 мл Просекко, 60 мл Aperol и 30 мл содовой.
            3. Перемешайте барной ложкой.
            4. Украсьте долькой апельсина.
        """.trimIndent(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Aperol_Spritz_aboard_Viking_Mariella.jpg/800px-Aperol_Spritz_aboard_Viking_Mariella.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 12,
                    name = "Raspberry Truffle",
                    ingredients = listOf("Водка", "Малиновый ликёр", "Кокосовое молоко", "Эспрессо"),
                    instructions = """
            1. В шейкер добавьте 40 мл водки, 20 мл малинового ликёра, 20 мл кокосового молока и 30 мл свежего эспрессо.
            2. Наполните шейкер льдом и хорошо взболтайте.
            3. Процедите в бокал со льдом.
            4. Украсьте свежей малиной.
        """.trimIndent(),
                    imageUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi4JjRErMvq3Q52UqoUKk7cP8K-BLJkdY0D1SRYT_JRS8Mefl5P4GIbTbJc_9Bw9qZe6F5ALuRTncL79_ZqPVHEeYyi4GtuCA3m_EA72Eo3b9cj20eZjfgtClzFJwgUFTdMgbLejhfeI8L7W1ylBwHd2gyfc7uaUABAMrZtXFNn7sqqKexiNDFhyjQ/s800/Raspberry-Truffle-Cocktail-Image%203.JPG",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 13,
                    name = "Московский мул",
                    ingredients = listOf("Водка", "Имбирное пиво", "Лайм"),
                    instructions = """
            1. Наполните медную кружку льдом.
            2. Добавьте 50 мл водки и сок половины лайма.
            3. Долейте имбирным пивом.
            4. Перемешайте барной ложкой.
            5. Украсьте долькой лайма.
        """.trimIndent(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Moscow_Mule_at_Rye%2C_San_Francisco.jpg/1920px-Moscow_Mule_at_Rye%2C_San_Francisco.jpg",
                    isAlcoholic = true
                ),
                CocktailPresenter(
                    id = 14,
                    name = "Лимонад",
                    ingredients = listOf("Лимон", "Сахар", "Вода"),
                    instructions = """
            1. Выжмите сок из 4 лимонов.
            2. Добавьте 4 столовые ложки сахара и 1 литр воды.
            3. Перемешайте до растворения сахара.
            4. Подавайте со льдом и долькой лимона.
        """.trimIndent(),
                    imageUrl = "https://static.mk.ru/upload/entities/2021/06/08/18/articles/detailPicture/cf/ff/6b/c2/887e9d711bfbeae436a81f75d53cef59.jpg", // Замените на реальную ссылку
                    isAlcoholic = false
                ),
                CocktailPresenter(
                    id = 15,
                    name = "Мохито без алкоголя",
                    ingredients = listOf("Лайм", "Мята", "Сахар", "Газированная вода"),
                    instructions = """
            1. Разрежьте лайм на четвертинки и положите в высокий бокал.
            2. Добавьте 6-8 листиков свежей мяты и 2 чайные ложки сахара.
            3. Аккуратно разомните лайм и мяту мадлером.
            4. Наполните бокал льдом.
            5. Долейте газированной водой.
            6. Перемешайте барной ложкой и украсьте веточкой мяты.
        """.trimIndent(),
                    imageUrl = "https://eda.show/content/images/2022/09/--------------2022-03-03---17.27.03.png", // Замените на реальную ссылку
                    isAlcoholic = false
                )
            )
        }
    }
}