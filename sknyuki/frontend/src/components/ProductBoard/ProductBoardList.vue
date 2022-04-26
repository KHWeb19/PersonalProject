<template>
<div>
    <br>
    
                        
          <v-card class="pa-3" flat>
            <v-row>
              <v-col v-for="productBoard in ProductBoardSs" :key="productBoard.boardNo"
                cols="12" sm="6" md="4" lg="3">
                <v-hover v-slot="{hover}" close-delay="50">
                  <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }"
                   @click="handleClick(productBoard)">
                    <v-list-item>
                      <v-list-item-title>
                        {{ productBoard.name }}
                      </v-list-item-title>
                    </v-list-item>
                    
                    <v-divider></v-divider>
                    <img :src="showFile(productBoard.boardNo,productBoard.id)"  width="100%"/>


                    <v-card-text class="caption">
                      Rank: {{productBoard.brandrank}}
                      <br>
                      Price: {{productBoard.price}}
                     
                    </v-card-text>
                  
                  </v-card>
                </v-hover>
              </v-col>
            </v-row>
          </v-card>
  <br>
  <v-row  justify="end">
       <!--name:homeview-> register로 변경예정-->
    <router-link style="text-decoration: none;" :to="{name:'K2ProductRegisterPage'}">   
    <v-btn class="blue lighten-5">
      <v-icon small>mdi-pencil</v-icon> 글쓰기</v-btn>
    </router-link></v-row>
    <br>
             
</div>
        
</template>

<script>
export default {
    name:'ProductBoardList',
    props:{
      ProductBoardSs: []
    },
  data () {
    return {
      boardNo:'1',
           
  }
  },
    methods: {
        
         showFile (a,b) {
      try {
        return require(`../../../../backend/demo/images/ProductBoardS/${a}_${b}.jpg`) 
    } catch (e) {
                return require(`@/assets/logo.png`)
                }
        
        
    },
    handleClick(productBoard){
       this.$router.push({
                            name: 'K2ProductReadPage',
                            params: { boardNo: productBoard.boardNo.toString() } },
    
            )
    },

    mounted () {
        console.log(this.ProductBoardSs.regDate)
        console.log(this.ProductBoardSs.boardNo)
    }
}
}
</script> 
<style scoped>
a:link {
  text-decoration: none;
  color: #000;
}
a:visited {
  color: #000;
}
a:hover {
  color: #356859;
}
</style>