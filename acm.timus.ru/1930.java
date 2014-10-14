import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Problem1930 implements Runnable {
	private BufferedReader bufferedReader;
	private StreamTokenizer in;
	private PrintWriter out;

	public Problem1930() {
		this(System.in, System.out);
	}

	public Problem1930(InputStream inputStream, OutputStream outputStream) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		in = new StreamTokenizer(bufferedReader);
		out = new PrintWriter(new OutputStreamWriter(outputStream));
	}

	public static void main(String[] args) throws IOException {
		new Problem1930().run();
	}

	public void run() {
		try {
			solve();
			out.flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private double readNumber() throws IOException {
		int nextToken = in.nextToken();
		if (nextToken == StreamTokenizer.TT_NUMBER) {
			return in.nval;
		}
		throw new IllegalStateException("Number expected. Found: " + nextToken);
	}

	private String readWord() throws IOException {
		int nextToken = in.nextToken();
		if (nextToken == StreamTokenizer.TT_WORD) {
			return in.sval;
		}
		throw new IllegalStateException("Word expected. Found: " + nextToken);
	}

	//TODO global variables

	private void solve() throws Exception {
        int n = (int) readNumber();
        int m = (int) readNumber();
        List<Integer>[][] a = new List[n][2];
        PriorityQueue queue = new PriorityQueue(n * 2);
        readGraph(a, m);
        fillQueue(queue, n * 2);
        int start = (int) readNumber() - 1;
        int end = (int) readNumber() - 1;
        queue.decValue(start, 0);
        queue.decValue(start + n, 0);
        while (!queue.isEmpty()) {
            int id = queue.extractMin();
            int value = queue.getValue(id);
            if (id == end || value == Integer.MAX_VALUE) {
                break;
            }
            int vertex = id % n;
            int direction = id / n;
            if (a[vertex][direction] != null) {
                for (int j : a[vertex][direction]) {
                    queue.decValue(j + direction * n, value);
                }
            }
            if (a[vertex][1 - direction] != null) {
                for (int j : a[vertex][1 - direction]) {
                    queue.decValue(j + (1 - direction) * n, value + 1);
                }
            }
        }
        out.println(Math.min(queue.getValue(end), queue.getValue(end + n)));
    }

    private void fillQueue(PriorityQueue queue, int n) {
        for (int i = 0; i < n; i++) {
            queue.add(i, Integer.MAX_VALUE);
        }
    }

    private void readGraph(List<Integer>[][] a, int m) throws IOException {
        for (int i = 0; i < m; i++) {
            int from = (int) readNumber() - 1;
            int to = (int) readNumber() - 1;
            add(a, from, to, 0);
            add(a, to, from, 1);
        }
    }

    private void add(List<Integer>[][] a, int from, int to, int id) {
        if (a[from][id] == null) a[from][id] = new LinkedList<Integer>();
        a[from][id].add(to);
    }

    private static final class PriorityQueue {
        private final PriorityQueueEntity[] entities;
        private final PriorityQueueEntity[] entitiesById;
        private int heapsize;

        public PriorityQueue(int size) {
            entities = new PriorityQueueEntity[size];
            entitiesById = new PriorityQueueEntity[size];
            heapsize = 0;
        }

        public void add(int id, int value) {
            PriorityQueueEntity entity = new PriorityQueueEntity(heapsize, id, Integer.MAX_VALUE);
            entities[heapsize] = entity;
            entitiesById[id] = entity;
            heapsize++;
            decValue(id, value);
        }

        private void decValue(int id, int newValue) {
            PriorityQueueEntity entity = entitiesById[id];
            if (entity.value <= newValue || entity.position >= heapsize) {
                return;
            }
            entity.value = newValue;
            int i = entity.position;
            int p = i / 2;
            while (i > 0 && entities[p].value > entity.value) {
                setEntity(i, entities[p]);
                i = p;
                p = i / 2;
            }
            setEntity(i, entity);
        }

        private void setEntity(int i, PriorityQueueEntity entity) {
            entities[i] = entity;
            entity.position = i;
        }

        public int extractMin() {
            PriorityQueueEntity extracted = entities[0];
            heapsize--;
            PriorityQueueEntity entity = entities[heapsize];
            setEntity(heapsize, extracted);
            entities[0] = entity;
            int i = 0;
            for (;;) {
                int l = i * 2;
                int r = l + 1;
                int min = i;
                if (l < heapsize && entities[l].value < entities[min].value) {
                    min = l;
                }
                if (r < heapsize && entities[r].value < entities[min].value) {
                    min = r;
                }
                if (min != i) {
                    setEntity(i, entities[min]);
                    setEntity(min, entity);
                    i = min;
                    continue;
                }
                break;
            }
            setEntity(i, entity);
            return extracted.id;
        }

        public boolean isEmpty() {
            return heapsize == 0;
        }

        public int getValue(int id) {
            return entitiesById[id].value;
        }
    }

    private static final class PriorityQueueEntity {
        private int position;
        public final int id;
        public int value;

        private PriorityQueueEntity(int position, int id, int value) {
            this.position = position;
            this.id = id;
            this.value = value;
        }
    }
}