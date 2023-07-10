package lesson_2;
public class lesson_2_1 {
    public static final String QUERY = "select * from students where ";
    public static final String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(QUERY);

        String params = PARAMS.substring(1, PARAMS.length() - 1);
        String[] keyValuePairs = params.split(", ");

        boolean isFirstParam = true;
        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].replaceAll("\"", "").trim();
            String value = keyValue[1].replaceAll("\"", "").trim();

            if (!value.equals("null")) {
                if (!isFirstParam) {
                    stringBuilder.append(" and ");
                }
                stringBuilder.append(key).append(" = '").append(value).append("'");
                isFirstParam = false;
            }
        }

        System.out.println(stringBuilder);
    }
}

