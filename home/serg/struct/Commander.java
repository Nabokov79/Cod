package home.serg.struct;

public class Commander {
    //объявляем поля в которых будут хранится данные
    CalculationMonthlyData calculationMonthlyData = new CalculationMonthlyData();
    CalculationYearData calculationYearData = new CalculationYearData();
    
    // это методы обработки комманд
    void command1(){
       //здесь считываешь файлы можешь своими классами, но возвращаешь оттуда объект CalculationMonthlyData
        // и присваиваешь его в переменную calculationMonthlyData которя поле этого класса
        // и так он остается в памяти и всегда доступен из методов этого класса
    }
    void command2(){
        //здесь считываешь файлы можешь своими классами, но возвращаешь оттуда объект CalculationYearData
        // и присваиваешь его в переменную calculationYearData и так он остается в памяти и всегда доступен из методов этого класса
    }
    // Но у тебя такая большая цепочка классов чтоб считать данные, что я бы задумался об упрощении
    // теперь у тебя во всех этих классах доступны данные, но чтоб ими пользоваться в методах других классов их надо передавать туда параметрами
    void command3(){
    
    }
    void command4(){
    
    }
    void command5(){
    
    }
}
