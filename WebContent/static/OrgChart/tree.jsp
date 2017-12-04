<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <meta charset="utf-8">
  <title>Organization Chart Plugin</title>
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/jquery.orgchart.min.css">
  <link rel="stylesheet" href="css/style.css">
  <style type="text/css">
    #chart-container { background-color: #eee; height: 530px; }
    .orgchart { background: #fff; }
    .orgchart.view-state .edge { display: none; }
    .orgchart .node { width: 150px; }
    .orgchart .node .title .symbol { margin-top: 1px; }
    #edit-panel {
      position: relative;
      left: 10px;
      width: calc(100% - 40px);
      border-radius: 4px;
      float: left;
      margin-top: 10px;
      padding: 10px;
      color: #fff;
      background-color: #449d44;
    }
    #edit-panel .btn-inputs { font-size: 24px; }
    #edit-panel.view-state>:not(#chart-state-panel) { display: none; }
    #edit-panel label { font-weight: bold; }
    #edit-panel.edit-parent-node .selected-node-group { display: none; }
    #chart-state-panel, #selected-node, #btn-remove-input { margin-right: 20px; }
    #edit-panel button {
      color: #333;
      background-color: #fff;
      display: inline-block;
      padding: 6px 12px;
      margin-bottom: 0;
      line-height: 1.42857143;
      text-align: center;
      white-space: nowrap;
      vertical-align: middle;
      -ms-touch-action: manipulation;
      touch-action: manipulation;
      cursor: pointer;
      -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
      background-image: none;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    #edit-panel.edit-parent-node button:not(#btn-add-nodes) { display: none; }
    #edit-panel button:hover,.edit-panel button:focus,.edit-panel button:active {
      border-color: #eea236;
      box-shadow:  0 0 10px #eea236;
    }
    #new-nodelist {
      display: inline-block;
      list-style:none;
      margin-top: -2px;
      padding: 0;
      vertical-align: text-top;
    }
    #new-nodelist>* { padding-bottom: 4px; }
    .btn-inputs { vertical-align: sub; }
    #edit-panel.edit-parent-node .btn-inputs { display: none; }
    .btn-inputs:hover { text-shadow: 0 0 4px #fff; }
    .radio-panel input[type='radio'] { display: inline-block;height: 24px;width: 24px;vertical-align: top; }
    #edit-panel.view-state .radio-panel input[type='radio']+label { vertical-align: -webkit-baseline-middle; }
    #btn-add-nodes { margin-left: 20px; }
  </style>
</head>
<body>
  <button style="position:absolute;left:15px; top:15px;z-index: 999;width: 50px;height: 30px;" onclick="goBack()">返回</button>
  <script type="text/javascript">
	function goBack(){
		window.history.back();
	}
	</script>
  <div id="chart-container"> </div>
  <div id="edit-panel" class="view-state">
    <span id="chart-state-panel" class="radio-panel">
      <input type="radio" name="chart-state" id="rd-view" value="view" checked="true"><label for="rd-view">查看模式</label>
      <input type="radio" name="chart-state" id="rd-edit" value="edit"><label for="rd-edit">启用编辑</label>
    </span>
    <label class="selected-node-group">请选择一个节点:</label>
    <input type="text" id="selected-node" class="selected-node-group">
    <label>新节点:</label>
    <ul id="new-nodelist">
      <li><input type="text" class="new-node"></li>
    </ul>
    <i class="fa fa-plus-circle btn-inputs" id="btn-add-input"></i>
    <i class="fa fa-minus-circle btn-inputs" id="btn-remove-input"></i>
    <span id="node-type-panel" class="radio-panel">
      <input type="radio" name="node-type" id="rd-parent" value="parent"><label for="rd-parent">父节点(root)</label>
      <input type="radio" name="node-type" id="rd-child" value="children"><label for="rd-child">子节点</label>
      <input type="radio" name="node-type" id="rd-sibling" value="siblings"><label for="rd-sibling">同级节点</label>
    </span>
    <button type="button" id="btn-add-nodes">增加</button>
    <button type="button" id="btn-delete-nodes">删除</button>
    <button type="button" id="btn-reset">重置</button>
  </div>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/html2canvas.min.js"></script>
  <script type="text/javascript" src="js/jquery.orgchart.min.js"></script>
  <script type="text/javascript">
    $(function() {

    var datascource = {
      'name': '祖',
      'children': [
        { 'name': '尹学金','children':[{'name':'尹秀如,夏应辉'},{'name':'尹春如,夏国旺'},{'name':'尹成旺,陈胜和'}] },
        { 'name': '尹兵权','children':[{'name':'尹成林,夏光辉'},{'name':'尹汗林,夏丽'},{'name':'尹秀芝,夏'}] },
        { 'name': '尹学权','children':[{'name':'尹旺林'}] },
        { 'name': '尹xx' }
      ]
    };

    var getId = function() {
      return (new Date().getTime()) * 1000 + Math.floor(Math.random() * 1001);
    };

    var oc = $('#chart-container').orgchart({
      'data' : datascource,
      'exportButton': true,
      'exportFilename': 'SportsChart',
      'parentNodeSymbol': 'fa-th-large',
      'createNode': function($node, data) {
        $node[0].id = getId();
      }
    });

    oc.$chartContainer.on('click', '.node', function() {
      var $this = $(this);
      $('#selected-node').val($this.find('.title').text()).data('node', $this);
    });

    oc.$chartContainer.on('click', '.orgchart', function(event) {
      if (!$(event.target).closest('.node').length) {
        $('#selected-node').val('');
      }
    });

    $('input[name="chart-state"]').on('click', function() {
      $('.orgchart').toggleClass('view-state', this.value !== 'view');
      $('#edit-panel').toggleClass('view-state', this.value === 'view');
      if ($(this).val() === 'edit') {
        $('.orgchart').find('tr').removeClass('hidden')
          .find('td').removeClass('hidden')
          .find('.node').removeClass('slide-up slide-down slide-right slide-left');
      } else {
        $('#btn-reset').trigger('click');
      }
    });

    $('input[name="node-type"]').on('click', function() {
      var $this = $(this);
      if ($this.val() === 'parent') {
        $('#edit-panel').addClass('edit-parent-node');
        $('#new-nodelist').children(':gt(0)').remove();
      } else {
        $('#edit-panel').removeClass('edit-parent-node');
      }
    });

    $('#btn-add-input').on('click', function() {
      $('#new-nodelist').append('<li><input type="text" class="new-node"></li>');
    });

    $('#btn-remove-input').on('click', function() {
      var inputs = $('#new-nodelist').children('li');
      if (inputs.length > 1) {
        inputs.last().remove();
      }
    });

    $('#btn-add-nodes').on('click', function() {
      var $chartContainer = $('#chart-container');
      var nodeVals = [];
      $('#new-nodelist').find('.new-node').each(function(index, item) {
        var validVal = item.value.trim();
        if (validVal.length) {
          nodeVals.push(validVal);
        }
      });
      var $node = $('#selected-node').data('node');
      if (!nodeVals.length) {
        alert('请输入新节点的值');
        return;
      }
      var nodeType = $('input[name="node-type"]:checked');
      if (!nodeType.length) {
        alert('请选择一个节点类型');
        return;
      }
      if (nodeType.val() !== 'parent' && !$('.orgchart').length) {
        alert('当您要从头开始构建组织图时，请先创建根节点');
        return;
      }
      if (nodeType.val() !== 'parent' && !$node) {
        alert('请在orgchart中选择一个节点');
        return;
      }
      if (nodeType.val() === 'parent') {
        if (!$chartContainer.children('.orgchart').length) {// if the original chart has been deleted
          oc = $chartContainer.orgchart({
            'data' : { 'name': nodeVals[0] },
            'exportButton': true,
            'exportFilename': 'SportsChart',
            'parentNodeSymbol': 'fa-th-large',
            'createNode': function($node, data) {
              $node[0].id = getId();
            }
          });
          oc.$chart.addClass('view-state');
        } else {
          oc.addParent($chartContainer.find('.node:first'), { 'name': nodeVals[0], 'Id': getId() });
        }
      } else if (nodeType.val() === 'siblings') {
        oc.addSiblings($node,
          { 'siblings': nodeVals.map(function(item) { return { 'name': item, 'relationship': '110', 'Id': getId() }; })
        });
      } else {
        var hasChild = $node.parent().attr('colspan') > 0 ? true : false;
        if (!hasChild) {
          var rel = nodeVals.length > 1 ? '110' : '100';
          oc.addChildren($node, {
              'children': nodeVals.map(function(item) {
                return { 'name': item, 'relationship': rel, 'Id': getId() };
              })
            }, $.extend({}, $chartContainer.find('.orgchart').data('options'), { depth: 0 }));
        } else {
          oc.addSiblings($node.closest('tr').siblings('.nodes').find('.node:first'),
            { 'siblings': nodeVals.map(function(item) { return { 'name': item, 'relationship': '110', 'Id': getId() }; })
          });
        }
      }
    });

    $('#btn-delete-nodes').on('click', function() {
      var $node = $('#selected-node').data('node');
      if (!$node) {
        alert('请在orgchart中选择一个节点');
        return;
      } else if ($node[0] === $('.orgchart').find('.node:first')[0]) {
        if (!window.confirm('您确定要删除整个图表吗？')) {
          return;
        }
      }
      oc.removeNodes($node);
      $('#selected-node').val('').data('node', null);
    });

    $('#btn-reset').on('click', function() {
      $('.orgchart').find('.focused').removeClass('focused');
      $('#selected-node').val('');
      $('#new-nodelist').find('input:first').val('').parent().siblings().remove();
      $('#node-type-panel').find('input').prop('checked', false);
    });

  });
  </script>
  </body>
</html>
