package esensats.su.oop;

import java.util.ArrayList;

public class Route {
    private static int s_idCnt = 0;
    private final int id;
    private String name;
    private Program program;
    private boolean hasProgram;
    private ArrayList<Route> children;

    /**
     * Create a nav route (no program)
     */
    public Route(String name) {
        this(name, new ArrayList<Route>());
    }

    /**
     * Create a nav route with children (no program)
     */
    public Route(String name, ArrayList<Route> children) {
        this(name, new Program() {
            @Override
            public boolean execute() throws Exception {
                throw new Exception("Route has no program to execute");
            }
        }, new ArrayList<Route>());
        this.hasProgram = false;
    }

    /**
     * Create a leaf route (has a program)
     */
    public Route(String name, Program program) {
        this(name, program, new ArrayList<Route>());
    }

    /**
     * Create a leaf route with children (has a program)
     */
    public Route(String name, Program program, ArrayList<Route> children) {
        this.id = Route.s_idCnt++;
        this.name = name;
        this.program = program;
        this.children = children;
        this.hasProgram = true;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Add child route
     */
    public Route addChild(Route child) {
        this.children.add(child);
        return this;
    }

    /**
     * Add a list of children
     */
    public Route addChildren(ArrayList<Route> children) {
        this.children.addAll(children);
        return this;
    }

    /**
     * Remove by object
     */
    public Route removeChild(Route child) {
        this.children.remove(child);
        return this;
    }

    /**
     * Remove by id
     */
    public Route removeChild(int id) {
        this.children.removeIf(child -> (child.getId() == id));
        return this;
    }

    /**
     * Get all child routes
     */
    public ArrayList<Route> getChildren() {
        return this.children;
    }

    public int getId() {
        return this.id;
    }

    public boolean hasProgram() {
        return this.hasProgram;
    }

    public boolean executeProgram() throws Exception {
        if (!this.hasProgram)
            throw new Exception("Route has no program to execute");
        else {
            return this.program.execute();
        }
    }
}
