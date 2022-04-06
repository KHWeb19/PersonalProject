<template>
  <div>
    <menu-bar/>
    <div style="display: flex; justify-content: center;">
      <accounts-category/>
      <password-edit-form/>
    </div>
  </div>
</template>

<script>
import PasswordEditForm from '@/components/member/PasswordEditForm.vue'
import AccountsCategory from '@/components/AccountsCategory.vue'
import MenuBar from '../../components/MenuBar.vue'

export default {
  name: 'AccountsEditPage',
  components: {
    PasswordEditForm,
    AccountsCategory,
    MenuBar
  },
}
</script>
