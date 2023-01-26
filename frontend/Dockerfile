# Use the LTS version of Node.js as the base image
FROM node:lts-alpine

RUN npm install -g @angular/cli@14
# Set the working directory in the container
WORKDIR /app

# Copy the package.json and package-lock.json files
COPY package*.json .

# Install the dependencies
RUN npm install

# Copy the rest of the application files
COPY . .


# Build the application
RUN ng build

# Expose the port that the application will run on
# EXPOSE 4200

RUN npm install -g serve

# Start the application
CMD ["serve", "/app/dist/frontend"]
