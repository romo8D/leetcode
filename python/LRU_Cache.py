#Design and implement a data structure for Least Recently Used #(LRU) cache. It should support the following operations: get and set.

#get(key) - Get the value (will always be positive) of the key #if the key exists in the cache, otherwise return -1.
#set(key, value) - Set or insert the value if the key is not al#ready present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

# Forgot a lot of self.  Miss self.tail = node; and  self.head = node; in setHead
class DoubleLinkedNode:
    def __init__(self, key, value):
        self.key = key;
        self.value = value;
        self.prev = None;
        self.next = None;
class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity;
        self.map = {};
        self.head = None;
        self.tail = None;
        self.len = 0;
    def get(self, key):
        if key not in self.map.keys(): return -1;
        node = self.map[key];
        self.remove(node);
        self.setHead(node);
        return node.value;
    def set(self, key, value):
        if key in self.map.keys():
            node = self.map[key];
            node.value = value;
            self.remove(node);
            self.setHead(node);
        else:
            node = DoubleLinkedNode(key,value);
            if self.len < self.capacity:
                self.len += 1;
            else:
                if self.tail:
                    oldTail = self.tail;
                    self.tail = self.tail.prev;
                    self.remove(oldTail);
                    del self.map[oldTail.key];
            self.setHead(node);
            self.map[key] = node;
    def remove(self, node):
        prev = node.prev;
        next = node.next;
        if prev:
            prev.next = next;
        else:
            self.head = next;
        if next:
            next.prev = prev;
        else:
            self.tail = prev;
    def setHead(self, node):
        if self.head:
            node.next = self.head;
            self.head.prev = node;
            node.prev = None;
            self.head = node;
        else:
            self.head = node;
            node.next = None;
            self.tail = node;
inst  = LRUCache(3);

inst.set(1,1);inst.set(2,2);inst.set(3,3);inst.set(4,4);
print inst.get(4);
print inst.get(3); 
print inst.get(2);
print inst.get(1);
inst.set(5,5);
print inst.get(1)
print inst.get(2);
print inst.get(3);
print inst.get(4);
print inst.get(5);
