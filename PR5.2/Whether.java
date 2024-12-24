class Whether {
    int temperature;
    int humidity;
    int windSpeed;
    String city;

    public Whether(int temperature, int humidity, int windSpeed, String city) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.format("City: %s, Temperature: %d°C, Humidity: %d%%, Wind Speed: %d km/h\n", city, temperature, humidity, windSpeed));

        if (temperature < -30) {
            result.append("It's too cold. Stay at home\n");
        } else if (temperature >= -30 && temperature <= 0) {
            result.append("It's recommended to stay at home. It's cold outside\n");
        } else if (temperature > 0 && temperature < 30) {
            result.append("It's a good time to take a walk\n");
        } else {
            result.append("It's too hot outside, stay hydrated!\n");
        }

        if (humidity > 85) {
            result.append("Take an umbrella, probably it's raining outside\n");
        }

        if (windSpeed > 15) {
            result.append("The wind speed is too fast. Be careful!\n");
        }

        return result.toString();
    }
}