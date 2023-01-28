FROM node:alpine as build-stage
RUN mkdir -p /app
WORKDIR /app
COPY  package.json /app/
RUN npm install
COPY . /app/
RUN npm install -g @angular/cli@14
RUN ng build --configuration production
FROM nginx:alpine
RUN rm -rf /usr/share/nginx/html/*
COPY --from=build-stage /app/dist/frontend /usr/share/nginx/html
