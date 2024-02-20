package esensats.su.oop;

import java.util.ArrayList;

public class Path {
    private ArrayList<Route> path;

    public Path(Route... path) {
        ArrayList<Route> list = new ArrayList<Route>();
        for (Route route : path) {
            list.add(route);
        }
        this.path = list;
    }

    public ArrayList<Route> getPath() {
        return this.path;
    }

    public Route getLast() throws Exception {
        if (path.size() >= 1)
            return path.get(path.size() - 1);
        else
            throw new Exception("EmptyPathException");
    }

    public Route getParent() throws Exception {
        if (path.size() >= 2)
            return path.get(path.size() - 2);
        else
            throw new Exception("NoParentException");
    }

    public Path append(Route route) {
        path.add(route);
        return this;
    }

    public Path pop() {
        path.remove(path.size() - 1);
        return this;
    }

    public int size() {
        return this.path.size();
    }
}
