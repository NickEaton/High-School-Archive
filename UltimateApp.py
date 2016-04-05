# Nick Eaton
# 11/11/2015
# UltimateApp.py

#Imports
from graphics import *
from random import *

#Player class
class Player():
    def __init__(self, name, pointsScored, pointsPlayed, position):
        self.name=name, self.scored=pointsScored, self.played=pointsPlayed, self.pos=position       
    def getName(self):
        return self.name
    def setName(self, name):
        self.name=name
    def setStats(self, pointsScored, pointsPlayed):
        self.scored=pointsScored, self.played=pointsPlayed
    def getStats(self):
        return self.name, self.scored, self.played, slef.pos
    def average(self):
        return self.scored/self.played

#Button Class
class Buttton():
    def __init__(self, label, p1, p2, win):
        self.label, self.p1, self.p2, self.win = label, p1, p2, win
        self.rect=Rectangle(p1, p2)
        self.rect.draw(self.win)
        self.textX=(self.p1.getX()+self.p2.getX())/2
        self.textY=(self.p1.getY()+self.p2.getY())/2
        self.text=Text(Point(self.textX, self.textY), label)
        self.text.draw(self.win)
    def setText(self, txt):
        self.text.setText(txt)
    def getText(self):
        return self.text.getText()
    def activate(self):
        self.rect.setOutline('Black')
        self.text.setFill('Black')
    def deActivate(self):
        self.rect.setOutline('White')
        self.text.setFill('White')
    def delete(self):
        self.rect.undraw()
        self.text.undraw()

#Initializes the player data file, if not
#Already in existance, otherwise, returns
#An empty list
def getPlayers(fname, players):
    i=1
    try:
        with open(fname, 'r') as infile:
            for line in infile:
                if(i%3==0):
                    players.append(line+',')
                i+=1
                players.append(line+'-')
            infile.close()
        return players
    except OSError:
        return players      

#Inputs a new player object and adds it
#To the file and to the player array
def updatePlayers(fname, array, newPlayer):
    infile = open(fname, 'a')
    infile.writeLines([newPlayer.name+";"+newPlayer.scored+";"+newPlayer.played])
    infile.close()
    array.append(newPlayer)
    return array

#Switches pages containing 16 players each
#For the number of users//16 + 1
def winSetPage(page, win):
    print('TODO')

#Simulates one points of 1v1 for two
#Given Player objects, returns a
#Boolean true if Player 1 wins
def simOnePointTrueIfPlayerOneWins(PlayerOne, PlayerTwo):
    compAvg=PlayerOne.average()/(PlayerOne.average()+PlayerTwo.average())
    x=random.random()
    if(x<compAvg):
        return True
    else:
        return False

#Simulates an entire game to
#11 Points, and returns boolean
#True if Player 1 is the winner
def simOneGameTrueIfPlayerOneWins(PlayerOne, PlayerTwo):
    PlOneScore=0
    PlTwoScore=0
    while PlOneScore!=11 and PlTwoScore!=11:
        result = simOnePointTrueIfPlayerOneWins(PlayerOne, PlayerTwo)
        if result:
            PlOneScore+=1
        else:
            PlTwoScore+=1
    if PlOneScore>=11:
        return True
    else:
        return False
    
def main():
    players = []
    players = getPlayers('players.txt', players)
    win = GraphWin('Ultimate Stats & Sim', 750, 750)
    win.setBackground('White')
    win.setCoords(-50, -50, 50, 50)
    
if __name__ == '__main__': main()
