<template>
  <v-tabs fixed-tabs color="grey darken-4" show-arrows center-active>
          <v-tab 
          v-for="item in items"
          :key="item.title" 
          >
            {{ item.title }}
          </v-tab>
          <v-tab-item
          v-for="item in items"
          :key="item.title" 
           >
           <v-container>
             
           </v-container>
          </v-tab-item>
      </v-tabs>
</template>

<script>
export default {
    name: 'tapMenu',
     data: () => ({
        tab: null,
        items: [
            {title: '서울'},
            {title: '경기'},
            {title: '인천'},
            {title: '부산'},
            {title: '제주'}
        ]
    }),
}
</script>

<style scope>
.v-tab {
  font-size: 15px;
}
</style>