<template>
<v-app class="sidebar">
  <v-card
    class="pa-12"
    flat
  >
    <v-card
      height="600"
      width="300"
    >
      <v-navigation-drawer
        floating
        permanent
      >
        <v-list
          dense
          rounded
        >
          <v-list-item
            v-for="item in items"
            :key="item.title"
            link
          >
            <v-list-item-icon>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>
    </v-card>
  </v-card>
</v-app>
</template>

<script>
  export default {
    data () {
      return {
        items: [
          { title: 'Home', icon: 'mdi-home' },
          { title: 'Calendar', icon: 'mdi-calendar-blank' },
          { title: 'CheckList', icon: 'mdi-checkbox-marked-outline' },
        ],
      }
    },
  }
</script>

<style scoped>

</style>