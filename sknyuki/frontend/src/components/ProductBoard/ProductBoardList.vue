<template>
<div>
    <br>
                        
          <v-card class="pa-3" flat>
            <v-row>
              <v-col v-for="productBoard in productBoards" :key="productBoard.productBoardNo"
                cols="12" sm="6" md="4" lg="3">
                <v-hover v-slot="{hover}" close-delay="50">
                  <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }"
                   @click="handleClick(productBoard)">
                    <v-list-item>
                      <v-list-item-title>
                        {{ productBoard.title }}
                      </v-list-item-title>
                    </v-list-item>
                    
                    <v-divider></v-divider>
                    <img :src="showFile(productBoard.writer,productBoard.productBoardNo)"  width="100%"/>


                    <v-card-text class="caption">
                      {{productBoard.condition}}
                      {{productBoard.price}}
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
    name:'ProductBoardList',
    props:{
      productBoards: []
    },
  data () {
    return {
           
  }
  },
    methods: {
        
         showFile (a,b) {
      try {
        return require(`../../../../frontend/images/ProductBoardImages/${a}_${b}.png`) 
    } catch (e) {
                return require(`@/assets/logo.png`)
                }
        
        
    },
    handleClick(productBoard){
       this.$router.push({
                            name: 'ProductBoardReadPage',
                            params: { productNo: productBoard.productNo.toString() } },
    
            )
    },

    mounted () {
        console.log(this.QuestionBoards.regDate)
        console.log(this.QuestionBoards.boardNo)
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