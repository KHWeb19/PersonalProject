<template>
<div>
    <br>
                        
          <v-card class="pa-3" color="primary" flat>
            <v-row>
              <v-col v-for="ProductBoard in ProductBoards" :key="ProductBoard.ProductBoardNo"
                cols="12" sm="6" md="4" lg="3">
                <v-hover v-slot="{hover}" close-delay="50">
                  <v-card :elevation="hover ? 16:2" class="{ 'on-hover': hover }"
                   @click="handleClick">
                    <v-list-item>
                      <v-list-item-title>
                        {{ ProductBoard.title }}
                      </v-list-item-title>
                    </v-list-item>
                    
                    <v-divider></v-divider>
                    <img :src="showFile(ProductBoard.writer,ProductBoard.ProductBoardNo)"  width="100%"/>


                    <v-card-text class="caption">
                      {{ProductBoard.condition}}
                      {{ProductBoard.price}}
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
      BrandCheckboards: []
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
    handleClick(){
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