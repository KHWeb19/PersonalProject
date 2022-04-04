<template>
    <v-container>
     <div id="app">
  <v-app id="inspire">
    <v-row justify="space-around">
      <v-menu
        bottom
        origin="center center"
        transition="slide-y-transition"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            color="primary"
            dark
            v-bind="attrs"
            v-on="on"
          >
           Bag
          </v-btn>
        </template>
  
        <v-list>
          <v-list-item
            v-for="(item, i) in items"
            :key="i"
            link
          >
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
  
      <v-menu
        transition="slide-y-transition"
        bottom
        right
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            class="deep-orange"
            color="primary"
            dark
            v-bind="attrs"
            v-on="on"
          >
            Clothes
          </v-btn>
        </template>
  
        <v-list>
          <v-list-item
            v-for="(item, i) in items"
            :key="i"
            link
          >
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
  
      <v-menu
        transition="slide-y-transition"
        bottom
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            class="purple"
            color="primary"
            dark
            v-bind="attrs"
            v-on="on"
          >
            Watch
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="(item, i) in items"
            :key="i"
            link
          >
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-row>
  </v-app>
</div>
    </v-container>
</template>
<script>
export default {
    name:'DropDown2',
    data(){
        return{
            items: [
                { title: 'VITTON' },
                { title: 'CHANEL' },
                { title: 'HERMES' },
                { title: 'GUCCI' },
            ],
        }
    }
}
</script>