package org.sse.examples;

public class TestTermoresistor
{
    private static final float ADC_ERROR = -1000;
    private static final int TERMISTOR_START = -40;
    private static final int TERMISTOR_STEP = 5;
    private static final int TERMISTOR_R1 = 4700;
    private static final int TERMISTOR_R25 = 5000;

    // Значения из документации. (Rt/R25) * 1000
// Для диапазона температур от -40 до +120 с шагом 5 градусов.
    private static int RTR25[] = {33650, 24260, 17700, 13040, 9707, 7293, 5533, 4232, 3265, 2539, 1990, 1571, 1249, 1000, 805, 653, 532, 437, 360, 298, 248, 208, 175, 148, 125, 107, 91, 78, 68, 58, 51, 44, 38};

    public static float getExtTemperature(int value)
    {
        if (value >= 3200 || value <= 5) return ADC_ERROR;

        float vRef = 3300;

        float vt = value;
        vt /= 1000;
        vRef /= 1000;

        float v1 = vt * TERMISTOR_R1;
        float v2 = vRef - vt;
        float rt = v1 * 1000 / v2;
        float rtr = rt / TERMISTOR_R25;

        int t = TERMISTOR_START;
        for (int i = 0; i < RTR25.length; i++)
        {
            if (rtr < RTR25[i])
            {
                t += TERMISTOR_STEP;
                continue;
            }

            if (i == 0) return ADC_ERROR;

            float dt_rtr = 0;
            if (i > 0) dt_rtr = RTR25[i - 1] - RTR25[i];
            float res = rtr - RTR25[i];
            res = (-TERMISTOR_STEP) * res / dt_rtr;
            res += t;

            return res;
        }

        return ADC_ERROR;
    }

    public static void main(String []args)
    {
        float res = TestTermoresistor.getExtTemperature(1701);
        System.out.println("temperature: " + res);
        assert ((int) (res * 10) == 250);

        res = TestTermoresistor.getExtTemperature(1637);
        System.out.println("temperature: " + res);
        assert ((int) (res * 10) == 269);
    }

}
