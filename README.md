## Queries
### Get All Players
```
{
  getPlayers {
    id
    name
    surname
    position
  }
}
```
### Get Player By ID
```
{
  getById(id: 1) {
    id
    name
    surname
    position
  }
}
```
### Get Player By Position
```
{
  getPlayersByPosition(position: "Center(C)") {
    id
    name
    surname
    position
  }
}
```
## Mutations
### Create Player
```
mutation {
  createPlayer(player: {name: "Name", surname: "Surname", position: "Shooting guard(SG)"}) {
    id
    name
    surname
    position
  }
}
```
### Delete Player
```
mutation {
  deletePlayer(id: 1)
}
```