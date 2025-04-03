# Nuxt Minimal Starter

Look at the [Nuxt documentation](https://nuxt.com/docs/getting-started/introduction) to learn more.

## Setup

Make sure to install dependencies:

```bash
# npm
npm install

# pnpm
pnpm install

# yarn
yarn install

# bun
bun install
```

## Development Server

Start the development server on `http://localhost:3000`:

```bash
# npm
npm run dev

# pnpm
pnpm dev

# yarn
yarn dev

# bun
bun run dev
```

## Production

Build the application for production:

```bash
# npm
npm run build

# pnpm
pnpm build

# yarn
yarn build

# bun
bun run build
```

Locally preview production build:

```bash
# npm
npm run preview

# pnpm
pnpm preview

# yarn
yarn preview

# bun
bun run preview
```

Check out the [deployment documentation](https://nuxt.com/docs/getting-started/deployment) for more information.



## Backend (Spring Boot & MySQL)

This project uses Spring Boot for the backend and MySQL Workbench for database management.

1. Change to the backend directory:
    ```bash
    cd backend
    ```

2. Build and run the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
    ```
   or with Maven:
    ```bash
    mvn spring-boot:run
    ```

3. Database Setup:
    - Ensure MySQL Workbench is installed and running.
    - Create a new database using MySQL Workbench.
    - Update the Spring Boot configuration (application.properties or application.yml) with your MySQL credentials and connection URL.
    - Example configuration in application.properties:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        spring.jpa.hibernate.ddl-auto=update
        ```