class TimeMap {

    private Map<String, List<Pair<Integer, String>>> map;

    private static class Pair<K, V> {
        V value;
        K key;

        public Pair(K key, V value) {
            this.value = value;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "value=" + value +
                    ", key=" + key +
                    '}';
        }
    }

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair<Integer, String> pair = new Pair<>(timestamp, value);
        map.computeIfAbsent(key, k -> new ArrayList<Pair<Integer, String>>()).add(pair);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            List<Pair<Integer, String>> list = map.get(key);
            String result = "";
            int l = 0;
            int r = list.size() - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (list.get(m).key == timestamp) return list.get(m).value;
                else if (list.get(m).key < timestamp) {
                    result = list.get(m).value;
                    l = m + 1;
                } else r = m - 1;
            }
            return result;
        } else return "";

    }
}
