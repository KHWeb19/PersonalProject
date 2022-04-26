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
       메모작성
      </h1>
      <br>

        <jpa-board-register-form @submit="onSubmit"/>
    </div>
</div>


   <v-footer app color="#FFFBE6" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; EDDI</span>
    </v-footer>
</div>
    

</template>

<script>
import JpaBoardRegisterForm from '@/components/jpaBoard/JpaBoardRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'BoardRegisterPage',
    components: {
        JpaBoardRegisterForm,
    },
    methods: {
        onSubmit (payload) {
            const { title, content, writer } = payload
            axios.post('http://localhost:7777/62th/board/register', { title, writer, content })
                    .then(() => {
                        this.$router.push({
                            name: 'JpaBoardListPage'
                        })
                    })
                    .catch(() => {
                      
                    })
        }
    }
}
</script>