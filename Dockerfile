FROM node:latest
WORKDIR /home/app
COPY ./app/package.json .
RUN npm install
ADD ./app/ .
EXPOSE 3000
CMD [ "node","server.js" ]
