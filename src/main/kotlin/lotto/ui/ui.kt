package lotto.ui

import camp.nextstep.edu.missionutils.Console

class ui {
    fun moneyInput() : Int{
        var money  = 0
        var control = 0
        try {
            println("구입금액을 입력해 주세요.")
            money = Console.readLine().toInt()
        } catch (e : Exception){
            println("[ERROR] 올바른 입력이 아닙니다.")
            control = 1
        }
        if (control == 1){ return 1 }
        if (control == 0){ moneyInputNotDivideException(money) }
        return money
    }

    fun correctNumber() : List<Int>{
        println("당첨 번호를 입력해 주세요.")

        var correctNumberNew = mutableListOf<Int>()
        var correctNumberOld = Console.readLine().split(",")

        for (i in 0..correctNumberOld.size-1){
            correctNumberNew.add(correctNumberOld[i].toInt())
        }
        correctNumberNew.toList()
        correctNumberRangeOverException(correctNumberNew)

        return correctNumberNew
    }

    fun bonusNumber() : Int {
        println("보너스 번호를 입력해 주세요.")
        var bonusNumber = Console.readLine()
        bonusNumberRangeOverException(bonusNumber.toInt())
        return bonusNumber.toInt()
    }

    fun printLottoResult(three : Int, four : Int, five : Int, fivebonus : Int, six : Int){
        println("당첨 통계\n---")
        print(lottoWinningDetails.THREE.message)
        println(" - "+three.toString()+"개")
        print(lottoWinningDetails.FOUR.message)
        println(" - "+four.toString()+"개")
        print(lottoWinningDetails.FIVE.message)
        println(" - "+five.toString()+"개")
        print(lottoWinningDetails.FIVEBONUS.message)
        println(" - "+fivebonus.toString()+"개")
        print(lottoWinningDetails.SIX.message)
        println(" - "+six.toString()+"개")
    }
}

enum class lottoWinningDetails(val message : String) {
    THREE("3개 일치 (5,000원)"),
    FOUR("4개 일치 (50,000원)"),
    FIVE("5개 일치 (1,500,000원)"),
    FIVEBONUS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX("6개 일치 (2,000,000,000원)")
}

fun moneyInputNotDivideException(money : Int) {
    if ((money % 1000) != 0){
        println("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다.")
        throw IllegalArgumentException("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다.")
    }
    if (money < 1000){
        println("[ERROR] 금액이 1000원 이상이여야 합니다.")
        throw IllegalArgumentException("[ERROR] 금액이 1000원을 넘지 않습니다.")
    }
}

fun correctNumberRangeOverException(correctNumber : List<Int>){
    for (i in correctNumber){
        if (i < 1 || i > 46){
            println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
}

fun bonusNumberRangeOverException(bonusNumber: Int){
    if (bonusNumber < 1 || bonusNumber > 46){
        println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}

