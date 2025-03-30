/*
 * Author:  Matthew Yeend
 * Project: Simple AI Agent
 * Version: v1.1.1
 * Date:    30/03/2025
 */

package matthewyeend.simpleaiagent;

import java.util.Random;

/**
 *
 * @author matthewyeend
 */

class Environment {
    private char[][] grid;
    private int agentX, agentY;
    private static final char CLEAN = '_';
    private static final char DIRTY = 'D';
    
    public Environment(int rows, int cols) {
        grid = new char[rows][cols];
        Random random = new Random();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextBoolean() ? CLEAN : DIRTY;
            }
        }
        
        agentX = random.nextInt(rows);
        agentY = random.nextInt(cols);
    }
    
    public boolean isDirty() {
        return grid[agentX][agentY] == DIRTY;
    }
    
    public void clean() {
        grid[agentX][agentY] = CLEAN;
        System.out.println("Cleaned position: (" + agentX + ", " + agentY + ")");
    }
    
    public void move() {
        Random random = new Random();
        agentX = random.nextInt(grid.length);
        agentY = random.nextInt(grid[0].length);
        System.out.println("Moved to: (" + agentX + ", " + agentY + ")");
    }
    
    public void display() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == agentX && j == agentY) {
                    System.out.print("A ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

class VacuumAgent {
    private Environment env;
    
    public VacuumAgent(Environment env) {
        this.env = env;
    }
    
    public void act() {
        if (env.isDirty()) {
            env.clean();
        } else {
            env.move();
        }
    }
}

public class SimpleAIAgent {

    public static void main(String[] args) {
        Environment environment = new Environment(5, 5);
        VacuumAgent agent = new VacuumAgent(environment);
        
        for (int i = 0; i < 10; i++) {
            environment.display();
            agent.act();
        }
    }
}
