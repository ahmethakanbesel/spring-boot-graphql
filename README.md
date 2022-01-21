## Queries
### Get All Players
```graphql
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
```graphql
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
```graphql
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
```graphql
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
```graphql
mutation {
  deletePlayer(id: 1)
}
```