<template>
  <v-card height="1000">
    <v-navigation-drawer
      absolute
      permanent
      left
    >
      <template v-slot:prepend>
        <v-list-item two-line>
          <v-list-item-avatar>
            <img src="https://randomuser.me/api/portraits/women/81.jpg">
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title>Jane Smith</v-list-item-title>
            <v-list-item-subtitle>Logged In</v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </template>

      <v-divider></v-divider>

      <v-list dense>
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
        >
          <v-list-item-icon>
            <router-link>
            <v-icon>{{ item.icon }}</v-icon>
            </router-link>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>


        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-card>
</template>

<script>



  export default {
    data () {
      return {
        items: [
          { title: 'Home', icon: 'mdi-home', route: '/' },
          { title: 'Calendar', icon: 'mdi-calendar-blank' },
          { title: 'CheckList', icon: 'mdi-checkbox-marked-outline' },
        ],
      }
    },
  }
</script>