public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        //TODO: напишите метод генерации массива температур пациентов
        float[] arrayTemp=new float[patientsCount];
        double scale = Math.pow(10,1);
         float temp;
        for(int i = 0;i<arrayTemp.length;i++)
        {
            temp = (float) ((Math.ceil(((Math.random()*(40-32))+32)*scale))/scale);
            arrayTemp[i] =temp;
        }
        return arrayTemp;
    }
    public static String getReport(float[] temperatureData) {
    String s = "";
    double scale = Math.pow(10,2);
    float summa = 0;
    int count=0,countHealPers = 0;
    for(int i = 0;i<temperatureData.length;i++) {
        s += temperatureData[i] + " ";
        summa +=temperatureData[i];
    if(temperatureData[i]>=36.2f && temperatureData[i]<=36.9f) {countHealPers++;}
    count++;
    }
    float averageTemp = (float) ((Math.round((summa/count)*scale))/scale);;
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        String report =
                "Температуры пациентов: " + s.trim() +
                        "\nСредняя температура: " + averageTemp +
                        "\nКоличество здоровых: " + countHealPers;

        return report;
    }
}
