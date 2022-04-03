<template>
  <v-row>
    <v-col>
      <v-btn fab class="float-right">
        <v-menu offset-y>
          <template v-slot:activator="{ on }">
            <v-btn v-on="on" fab>
              <v-icon x-large>mdi-lead-pencil</v-icon>
            </v-btn>
          </template>

          <v-list>
            <v-list-item v-for="(dropItem, index) in dropItems" :key="index" link>
              <v-list-item-title>
                {{ dropItem.title }}
              </v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-btn>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "BeforePencilIcon",
  data() {
    return{
      dropItems: [
        {title: '일정생성'},
        {title: '친구초대'},
      ]
    }
  },
}
</script>

<style scoped>

</style>