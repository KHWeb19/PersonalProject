<template>
  <v-footer padless>
    <v-card flat width="100vw" tile class="black text-left pt-10">
      <div class="justify center">
        <v-card-text class="footer">
          <p style="margin-top:1%;"><b>Privacy</b><b style="padding-left:1%;">Cookies</b><b style="padding-left:1%;">Business</b><b style="padding-left:1%;">Accessibility</b><b style="padding-left:1%;">Help</b></p>
          <p style="margin-bottom:3px;"><b>ATELIER</b> The Village <b style="padding-left:1%;">ADDRESS</b> The Village , Atelier3 Ro, AtelierGu, Seoul, South Korea
          <p style="margin-bottom:3px;"><b>BUSINESS LICENSE</b> 777-77-7777 ( CEO :The Village)</p>
        </v-card-text>
      </div>

      <v-divider></v-divider>
      <v-card-text class="input">
          {{ new Date().getFullYear() }} — <b>COPYRIGHT(C) ATELIER COMPANY. ALL RIGHTS RESERVED.</b>
        </v-card-text>
    </v-card>
  </v-footer>
</template>


<script>

  export default {
    
    data() {
      return {
      
      }
    }
  }
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Poiret+One&display=swap');

.footer{
  color:white;
  font-family: 'Poiret One', cursive;
  font-size:15px;
}
.input{

  color:white;
  font-family: 'Poiret One', cursive;
  font-size:15px;
}




</style>