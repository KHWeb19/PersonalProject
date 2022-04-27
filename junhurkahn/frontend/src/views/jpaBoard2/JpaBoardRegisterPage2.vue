<template>

<div class="p-3 mb-2 bg-light text-dark">
<div>
  <v-card color="basil">
    <v-card-title class="text-center justify-center py-6">
      <h1 class="font-weight-bold text-h2 basil--text"  >
       Note
      </h1>
    </v-card-title>

    <v-tabs
      v-model="tab"
      background-color="transparent"
      color="basil"
      grow
    >
      <v-tab
      >
      </v-tab>
    </v-tabs>
  </v-card>

    <div align="center">
        <br>
         <h1 class="font-weight-bold text-h4 basil--text"  >
       장보기 작성
      </h1>
      <br>
        <jpa-board-register-form-2 @submit="onSubmit"/>
    </div>
</div>



   <v-footer app color="#FFFBE6" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; EDDI</span>
    </v-footer>
</div>
    

</template>

<script>
import JpaBoardRegisterForm2 from '@/components/jpaBoard2/JpaBoardRegisterForm2.vue'
import axios from 'axios'

export default {
    name: 'BoardRegisterPage2',
    components: {
        JpaBoardRegisterForm2
    },
    methods: {
        onSubmit (payload) {
            const { title, content,} = payload
            axios.post('http://localhost:7777/62th/board2/register2', { title, content })
                    .then(() => {
                       
                        this.$router.push({
                            name: 'JpaBoardListPage2'
                        })
                    })
                    .catch(() => {
                      
                    })
        }
    }
}
</script>