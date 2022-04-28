<template>
<div>
    <br>            
          <v-card class="pa-3" flat>
            <v-row>
              <v-col v-for="productBoard in ProductBoardBs" :key="productBoard.boardNo"
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
                    <img :src="showFile(productBoard.boardNo)"  width="100%"/>


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
</div>
        
</template>

<script>
export default {
    name:'SoldBoardList',
    props:{
      ProductBoardBs: []
    },
  data () {
    return {       
  }
  },
    methods: {
        
         showFile (a) {
      try {
        return require(`../../../../backend/demo/images/ProductBoardS/${a}.jpg`) 
    } catch (e) {
                return require(`@/assets/logo.png`)
                }
        
        
    },
    handleClick(productBoard){
       this.$router.push({
                            name: 'K2SoldReadPage',
                            params: { boardNo: productBoard.boardNo.toString() } },
    
            )
    },

    mounted () {
        console.log(this.ProductBoardBs.regDate)
        console.log(this.ProductBoardBs.boardNo)
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