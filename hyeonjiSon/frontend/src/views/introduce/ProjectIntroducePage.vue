<template>
<div align="center">
   <br><br>
   <h1> Project: 3re GUIDE </h1>
   <br><br><br>
   <v-container>
      <v-row justify="center">
         <img src="@/assets/introduce/introduce.png" height="381px"/>
         &ensp;&ensp;
         <introduce-p/>
      </v-row>
   </v-container>
</div>
</template>

<script>
import introduceP from '@/components/introduce/introduceP.vue'

export default {
    name: 'projectIntroducePage',
    components: {
       introduceP
    }
}
</script>

<style scoped>
h1{
  color: #907bb0;
}
</style>