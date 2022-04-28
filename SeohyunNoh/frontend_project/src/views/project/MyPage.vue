<template>
  <v-container>

      <div class="mt-5" cols="12" md="6">
        <my-info-check/>
      </div>
      <div class="mt-13" cols="12" md="6">
        <my-activity/>
      </div>

    
  </v-container>

</template>


<script>

import MyInfoCheck from '@/components/project/MyInfoCheck.vue'
import MyActivity from '../../components/project/MyActivity.vue'

export default {
  components: {
    MyInfoCheck,
    MyActivity
  }
}
</script>