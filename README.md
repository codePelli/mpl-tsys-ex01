# mpl-tsys-ex02

## Features

- User registration and authentication
- Party creation and joining
- Sending and editing messages within parties
- Managing user profiles

## Endpoints

### Users

- **Register User**
  - Route: `POST /api/users`
  - Description: Register a new user.
  - Request: `{"username": "user1", "password": "password1", "email": "user1@example.com", "steamUsername": "steam_user1"}`
  - Response: `{"id": 1, "username": "user1", "email": "user1@example.com", "steamUsername": "steam_user1"}`

- **Login**
  - Route: `POST /api/users/login`
  - Description: Authenticate a user.
  - Request: `{"username": "user1", "password": "password1"}`
  - Response: `{"token": "token"}`

- **Update User Profile**
  - Route: `PUT /api/users/:id`
  - Description: Update user profile information.
  - Request: `{"email": "new_email@example.com", "steamUsername": "new_steam_user"}`
  - Response: `{"id": 1, "username": "user1", "email": "new_email@example.com", "steamUsername": "new_steam_user"}`

### Videogames

- **Get Video Game by ID**
  - Route: `GET /api/video-games/:id`
  - Description: Get information about a specific video game.
  - Response: `{"id": 1, "gameName": "Metal Gear", "platform": "PlayStation"}`

### Parties

- **Create Party**
  - Route: `POST /api/parties`
  - Description: Create a new party.
  - Request: `{"creatorUserId": 1, "videoGameId": 1, "partyName": "Party1"}`
  - Response: `{"id": 1, "creatorUserId": 1, "videoGameId": 1, "partyName": "Party1"}`

- **Search Parties by Video Game**
  - Route: `GET /api/parties/search?videoGameId=1`
  - Description: Search for parties for a specific video game.
  - Response: `[{"id": 1, "creatorUserId": 1, "videoGameId": 1, "partyName": "Party1"}]`

- **Join Party**
  - Route: `POST /api/parties/join`
  - Description: Join an existing party.
  - Request: `{"userId": 2, "partyId": 1}`

- **Leave Party**
  - Route: `POST /api/parties/leave`
  - Description: Leave a party.
  - Request: `{"userId": 2, "partyId": 1}`

### Messages

- **Send Message**
  - Route: `POST /api/messages`
  - Description: Send a message in a party.
  - Request: `{"userId": 1, "partyId": 1, "content": "Hello, Party1!"}`
  - Response: `{"id": 1, "senderUserId": 1, "partyId": 1, "content": "Marc here from aprty 1"}`

- **Edit Message**
  - Route: `PUT /api/messages/:id`
  - Description: Edit a previously sent message.
  - Request: `{"userId": 1, "newContent": "Edited message"}`
  - Response: `{"id": 1, "senderUserId": 1, "partyId": 1, "content": "Edited message"}`

- **Delete Message**
  - Route: `DELETE /api/messages/:id`
  - Description: Delete a message.
  - Request: `{"userId": 1}`

- **Get Party Chat**
  - Route: `GET /api/messages/party-chat/:partyId`
  - Description: Get the chat history of a specific party.
  - Response: `[{"id": 1, "senderUserId": 1, "partyId": 1, "content": "Marc here from aprty 1"}]`
