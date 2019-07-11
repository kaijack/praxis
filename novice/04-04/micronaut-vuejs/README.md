# micronaut-vuejs

VueJS and Micronaut are currently two of my favorite technologies, and they complement 
each other beautifully: VueJS handles the front end, while Micronaut runs the back end.

However, getting a project set up that plugs them both together requires a lot of configuration
steps. This is simple skeleton project to enable rapid creation of a VueJS front end backed by 
Micronaut backend with just a couple of commands.

## Requirements

Make sure you have a recent version of `npm` and vuecli3 installed.

## Project setup
```
git clone https://gitlab.com/ssadedin/micronaut-vuejs.git <your-project-name>
cd <your-project-name>
npm install
./gradlew -b setup.gradle setup
```

### Compiles and hot-reloads for development

Terminal 1 - launch Micronaut:
```
./gradlew run
```

Terminal 2 - launch VueJS dev server:
```
npm run serve
```

### Compiles and minifies for production, using Docker
```
bash -e build.sh
```

### Lints and fixes files
```
npm run lint
```

### Run your end-to-end tests
```
npm run test:e2e
```

