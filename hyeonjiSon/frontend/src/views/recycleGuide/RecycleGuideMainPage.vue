<template>
<div >
   <br> <br> <br>
   <v-container align="center">
   <v-row justify="center">
      <v-dialog  v-model="findPw" resisten max-width="500px">
         <template v-slot:activator="{ on }">
         <v-card
                  :elevation="hover ? 16:2" v-on="on" 
                  @click="goPolicy"
                  style="margin: 35px; width: 300px; height: 650px;">
            <v-img src="@/assets/guidePage/guide_policy.jpg" />
         </v-card>
         </template>

               <v-card align="center">
                  <v-img src="@/assets/updating.jpg"/> 
               <br>
                  <v-card-actions>
                     <v-spacer></v-spacer>
                     <v-btn style="background-color: darkKhaki; color: white; " text @click.native="btn_click($event)">
                           OK
                     </v-btn>
                  </v-card-actions>
               </v-card>

      </v-dialog>

      <!--
      <v-card
               :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
               @click="goPolicy"
               style="margin: 35px; width: 300px; height: 650px;">
         <v-img src="@/assets/guidePage/guide_policy.jpg" />>
      </v-card>

       -->

      <v-card
               :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
               @click="goSearch" dark
               style="margin: 35px; width: 300px; height: 650px;">
         <v-img src="@/assets/guidePage/guide_search.jpg" />
      </v-card>

      <v-card
               :elevation="hover ? 16:2" class="{ 'on-hover': hover }" 
               @click="goBox" dark
               style="margin: 35px; width: 300px; height: 650px;">
         <v-img src="@/assets/guidePage/guide_box.jpg" />
      </v-card>

   </v-row>
   </v-container>
</div>
</template>

<script>

export default {
   name: "GuideMainPage",
   components: {
   },
   methods: {
      goSearch(){
         this.$router.push({ name: 'guideSearchPage'}) 
      },
      goBox(){
         this.$router.push({ name: 'guideBoxMainPage'}) 
      }

}
}
</script>

<style scoped>
img {
   margin: 35px;
}
</style>