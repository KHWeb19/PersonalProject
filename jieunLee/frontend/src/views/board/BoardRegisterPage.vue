<template>
  <div>
    <menu-bar :member="member"/>
    <board-register-form/>
  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
import BoardRegisterForm from '../../components/board/BoardRegisterForm.vue'

export default {
  components: {
    MenuBar,
    BoardRegisterForm
  }
}
</script>

<style>


</style>