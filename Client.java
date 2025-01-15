package interfaise;
import java.util.*;
public class Client : Ibank
{
    private String name; // имя клиента
    private double summa_bank; // сумма вклада

    // конструктор
    public Client(String name, double summa_bank)



    // реализация методов интерфейса Ibank
    // Положить деньги на счет
    public void put(double summa)
    {
        summa_bank += summa;
    }

    // Снять деньги со счета
    public void get(double summa)
    {
        if (summa <= summa_bank)
            summa_bank -= summa;
    }
}

