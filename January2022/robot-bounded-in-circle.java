/*
On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

- "G": go straight 1 unit;
- "L": turn 90 degrees to the left;
- "R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Link: https://leetcode.com/problems/robot-bounded-in-circle/
*/

class Solution {
    private enum Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }
    
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        Direction direction = Direction.NORTH;
        
        for(char instruction : instructions.toCharArray()) {
            if(instruction == 'G') {
                switch(direction) {
                    case NORTH:
                        y++;
                        break;
                        
                    case SOUTH:
                        y--;
                        break;
                        
                    case EAST:
                        x++;
                        break;
                        
                    case WEST:
                        x--;
                        break;
                }
            } else if(instruction == 'L') {
                switch(direction) {
                    case NORTH:
                        direction = Direction.WEST;
                        break;
                        
                    case SOUTH:
                        direction = Direction.EAST;
                        break;
                        
                    case EAST:
                        direction = Direction.NORTH;
                        break;
                        
                    case WEST:
                        direction = Direction.SOUTH;
                        break;
                }
            } else if(instruction == 'R') {
                switch(direction) {
                    case NORTH:
                        direction = Direction.EAST;
                        break;
                        
                    case SOUTH:
                        direction = Direction.WEST;
                        break;
                        
                    case EAST:
                        direction = Direction.SOUTH;
                        break;
                        
                    case WEST:
                        direction = Direction.NORTH;
                        break;
                }
            }
        }
        
        if(x == 0 && y == 0) {
            return true;
        }
        
        if(direction == Direction.NORTH) {
            return false;
        }
        
        return true;
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
