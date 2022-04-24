<template>
      <v-container>
      <v-row class="justify-center">
        <v-col cols="6">
          <v-hover v-slot:default="{ hover }">
            <v-card
              to="/pools"
              :elevation="hover ? 12 : 2"
              :class="{ 'on-hover': hover , 'overwrite-hover' : $vuetify.breakpoint.xsOnly}"
            >
              <v-img class="white--text" :src="images[0]">
                <v-card-title class="white--text align-end fill-height headline">My Pools</v-card-title>
                <template v-slot:placeholder>
                  <v-row class="fill-height" align="center" justify="center">
                    <v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular>
                  </v-row>
                </template>
              </v-img>
            </v-card>
          </v-hover>
        </v-col>
        <v-col cols="2">
          <v-card class="ma-2" light height="50%"></v-card>
          <v-card class="ma-2" light height="50%"></v-card>
        </v-col>
      </v-row>
      <v-row class="justify-center">
        <v-col cols="8">
          <v-card light height="120px"></v-card>
        </v-col>
      </v-row>
   </v-container>
</template>

<script>
export default {
    name:'ProductBoardRegister',
    
    
}
</script>