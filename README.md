# Temple of Nur
## Overview
Similar to ‘Wizardry’ in game sense, ‘Temple of Nur’ takes a spin on the traditional dungeon exploring genre by having you enter these secret dungeons alone instead of going as an entire party. With this players will be forced to work around their selected classes' inherent weaknesses and incapabilities through various strategic and creative methods.
The objective of your character is to make it through the dungeon, avoiding obstacles and monsters along the way to reach the ‘Tome of Idris’. Your character's actual reason for attaining this ancient tome varies depending on your class and eventual grade.
Denomination System
Players will be given the option of selecting their character denominations when starting the game. These are split into the following:
Mage - Mages represent the embodiment of magic and mana itself. They have spent their lives dedicating themselves to that craft and as such have a ranged centered build with high attack and low defense.
Gish - Gishes represent the intersection between devout magical practice and adeptness in physical combat. While they are no strangers to the use of magic, their skillfulness with it greatly falters against that of mages. However to make up for this they have armed themselves with the physical skills to take on enemies even without magic. Gishes combine the two to create a combat style that merges the best parts of both.
Knight - Knights are sort of like Gishes in this aspect. Knights whilst technically making use of the two, still use them separately. They have a decent grasp of magic but not on the level of a mage or gish. Their physical capabilities and stats far exceed those of the two denominations however. Maintaining their knightly virtue, they tend to limit themselves to only a few types of magic as the others are seen as unholy or unorthodox by the church.
Barbarian - The most brutal of the denominations, barbarians pride themselves by their overwhelming strength and combat capabilities. Their environments have forged them into unyielding fighters, and they are constantly fighting in life or death situations out in the harsh clutches of nature. They have the highest strength and defense of the classes but have significantly lower knowledge and luck.

** Grades exist within these denominations; Represent lateral growth within your chosen denomination and allegiance. This is to say that multiple grades of the same skill level within the same denomination can exist


## Statistics
This will act as the central backbone to which all combat within the game operates on. The game will have 5 primary statistics:
 - Vitality(VIT) - This is less of a stat and more of a general attribute that all characters regardless of denomination will share. This represents the amount of health that a character has and will incrementally increase depending on a character's level.
 - Arcana(ARC) - This is essentially the amount of mana that a character has. Any magic based attack they perform will consume mana and decrease the amount of arcana they have. (Barbarians Arcana bar will be permanently disabled)
 - Attack(ATK) - This is relatively simplistic, representing the amount of damage a character will do when attacking(without any status or weapon buffs).
 - Intelligence(INT) - Scales magic based attacks as well as attack consumption. Having high intelligence not only decreases your overall mana consumption but also reduces the chance of missing magic based attacks.
 - Defense(DEF) - There are two types of defense. Magic defense and Physical defense. The base defense stat affects both of these, meaning that if my character has 50 defense then they have 50 magic defense and 50 physical defense respectively.
 - Luck(LUK) - Within the combat system of the game there exists a mechanic that lets players to miss their attack or fail to inflict status ailments onto enemies. This is largely determined by the player's luck. This will also be applied to non-combat areas of the game such as treasure acquisition or encounter rate.

** future update: players and enemies have weaknesses to certain status ailments (lightning, flame, etc.)
## Dungeon Mapping
The mapping for the dungeon will work similar to the way it works for blasphemous. Players will be able to unlock teleportation gates the further along in the dungeon they travel and can essentially use that as a form of fast travelling. Players can open up the map and this will display the areas they have already visited within the dungeon.
Essentially there will be a main map showing individual floors separately then the player can decide to look at the inner map of a layer.







## Character Creation
On creation (and start) of a new game a player will be prompted with a character creation screen. Here they will be able to select their denomination, change their character's name, and select starter equipment for their character.
Through a method we’ll take a character model with all the base stats set to 10 then depending on their class these will be updated accordingly to match. Giving the player their starting character.

## Weapons
Weapons work similarly to Persona’s in the game persona. For every weapon that a player equips, it will have certain skills that can be performed by the player and that damage will be scaled with the player's own stats. These skills can also apply status ailments to enemies or be used to affect the player in some way. (similar to how status or recovery items work)
 
## Items
Items are consumables within the game and can be obtained from shops or dropped by enemies.(Potential feature to allow players to create their own potions). There will be three types of items the player will be able to use.
First is Status Items. These have the ability to temporarily increase the stats of a character. Lower level status items affect only one stat for a couple of turns where higher grade status items can affect multiple for longer durations.
Next is Affliction Items. These are purposefully meant to target enemies or any opposing entities. This can be in the form of flat attack, or dropping the stats of an enemy. These items can also apply certain ailments to enemies.
Lastly is Recovery Items. This just refers to items that replenish a player's vitality or arcana.
**Add item/artifact types for stat boosting ones
## Status Ailments
Status Ailments fall into two categories; Buffs or Debuffs. Buffs improve the general stats of a player or enemy while debuffs do the opposite. Entities within the game can have a total of 3 status slots that can be filled at a time meaning that they have to think strategically before using items for these status ailments.
## Enemies
Enemies within the game are magical beasts that are produced by the dungeon itself. They function similarly in terms of stats and skills but don't require weapons to execute some high level skills, their physiology acting as a capable medium in doing so. Enemies in this game are split into normal enemies, and floor masters. These floor masters block the path towards the next floor. 
## Economics
The currency used in the game is gold coins and this can either be dropped by enemies or can be obtained when players trade whatever resources acquired from these enemies.With this gold players can buy weapons and items.
** future add armour
##Gameplay
### GameFlow
The player begins descending into the depths of the dungeon, but throughout the game can leave the dungeon to recuperate back at the village. Teleportation waypoints in the game make it possible to do so, with one being positioned right outside the dungeon. When a plate dies they respawn back at the last teleportation waypoint having lost all their gold. The player beats the game after having beaten the floor master at the tenth floor and retrieving the Tome of Idris.
Movement
For the most part it follows a traditional top down pokemon esque movement pattern with the only difference being when a player encounters an enemy. Where it switches to a persona-esque turn based fighting system. 

### Typical Game Loop
 
## Damage Calculation
###Types of Damage
The two main sources of damage are:
 - Physical Damage
 - Magic Damage
With these having sub types. The subtypes are primarily used to inflict a certain status onto enemies.
For example, a player can use the ‘Slash’ attack which is a physical attack of the ‘Bleed’ sub-damage type, meaning that the enemy is inflicted with the ‘Bleeding’ status which drains their vitality by a certain amount for x-amount of turns.
With this being the case damage can really only come from player/enemy active attacks, items, the effect of a status ailment inducing attack/item.

Damage is calculated with the following variables in mind.
```bash
v_player_atk
v_player_int
v_enemy_def
V_player_luck
v_skill_check (probability of landing attack with no luck in mind)
v_status_check
v_skill_damage_multiplier (main damage scaling)
item_atk_buff
weapon_atk
```
### Physical Damage:
```bash
Damage: ((v_player_atk+v_weapon_atk)+(1*item_atk_buff)) * v_skill_damage_multiplier
Damage: Damage - (Damage*v_enemy_def)
Damage: 	If(RNG<(v_skill_check%+(v_player_luck%*v_skill_check)%)
 { 
HIT 
} else 
{ 
MISS
 }
Magical Damage: ^ ++
		If(RNG<(v_status_check%+(v_player_luck%*v_status_check)%)
 { 
HIT 
} else 
{ 
MISS
 }
```
 

## Activities List
 - UI Design
   - Title Card(Start Screen)
   - First Option Screen
  	  Background Image Animation
 - Player Setup
	 - Base Classes Created and implemented (Based on ERD)
	 - Class Selection Screen
	 - Name Selection Screen
	 - Sprite Creation
 - Main Game
	 - ~~Movement~~
	 - ~~Collisions~~
	 - ~~Map Creation~~
	 - Floors
	 - Inventory Checking
	 - Pause Menu
	 - Fight Encounters
	 - Environment interactions
	 - Tileset Creation (Dungeon)
	 - Sprite animation
	 - Dialogue Screens
 - Fight Sequence

## General Sequence
Create a prototype - by using only cubes, spheres, capsules with no texture create your game and your main core mechanics. You will see how fun the game is, what the general feel is, is it boring or maybe some core elements should be changed.
Expand the prototype to the additional elements that you want to include in your game like mini games, special weapons etc. That's kinda the last, best moment you will get to make big changes. EDIT. Also show it off to people to get feedback
Now you should be SURE that you want to make this exact game with those elements and they feel fun. It's time to decide on art direction - how the game should look like, the general feeling of the game, color palette
With the specific art direction to make models and textures, animations could be added later. Also add a very basic UI, so you can start using your implemented before mechanics
Create new levels/world where you will place the main character and test it. See how the game feels with new look, make adjustments
Give the UI a new look to fit your gameplay
Add sound/music
Now add small things to the game like new versions of weapons, types of enemies etc


