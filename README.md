# Prerequisites

- Ensure you have JDK/JRE installed to run the Spring Boot backend.
- Ensure Node.js is installed to run the Nuxt frontend.
- MySQL Workbench (or another MySQL client) is recommended for managing your database.

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
    
    
    ## Tailwind CSS Setup
    
    Follow these steps to add Tailwind CSS to your Nuxt 3 project:
    
    1. Install Tailwind CSS and its peer dependencies:
        ```bash
        npm install -D @nuxtjs/tailwindcss
        ```
    
    2. Add the Tailwind CSS module to your Nuxt configuration by updating your `nuxt.config.ts`:
        ```ts
        export default defineNuxtConfig({
          modules: ['@nuxtjs/tailwindcss'],
        })
        ```
    
    3. (Optional) Customize your Tailwind configuration by creating a `tailwind.config.js` file:
        ```js
        module.exports = {
          content: [
            './components/**/*.{vue,js}',
            './layouts/**/*.vue',
            './pages/**/*.vue',
            './plugins/**/*.{js,ts}',
            './nuxt.config.{js,ts}',
          ],
          theme: {
            extend: {},
          },
          plugins: [],
        }
        ```
    
    4. (Optional) Create a custom CSS file (e.g., `assets/css/main.css`) and import Tailwind’s base, components, and utilities:
        ```css
        @tailwind base;
        @tailwind components;
        @tailwind utilities;
        ```
    
    5. Include your custom CSS file in Nuxt by updating `nuxt.config.ts`:
        ```ts
        export default defineNuxtConfig({
          css: ['~/assets/css/main.css'],
          modules: ['@nuxtjs/tailwindcss'],
        })
        ```